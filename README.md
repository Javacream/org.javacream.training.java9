*org.javacream.training.java9*

# Java 9 Update Training
## Basic Advantages
- Performance u. mem footprint jvm  
    &rarr; jre hochziehen bringt evtl. bereits vorteile 
- Erweiterungen in d. library
    - Collections API factory methoden, weitere kleinigkeiten
    - Reactive programming model (extremere Form async programming)
milde spracherweiterungen (generics variablen typen compiler type inference verbessert)  

## Project Jigsaw
### Modulkonzept 
- module seit min. 10-15 jahren bekannt und etabliert
- OSGI, jBoss (vom funktionsumfang ausgereifter)

### Auswirkungen Modulkonzept:
- programmierung
    - Vorher: `package` + `import`
    - Neu: `module-info.java`
- Design & Architektur
    - Vorher: `Consumer` &rarr; `<<Interface>>` <|- `Implementation`. Verletzung durch programming zur implementierung m&ouml;glich
    - Neu: programmierung zur implementierung sperren. API vom Modul definiert
    - Ebenfalls: Modul-Dependencies
- Build-Prozess
    - Neu: Module ber&uuml;cksichtigen (bauen + benutzen)  
    &rarr; build tools m&uuml;ssen aktualisiert werden (maven compiler plugin!)  
    &rarr; build prozesse m&uuml;ssten bisher unterschiedliche artefakte liefern wenn modularisierung gewollt w&auml;re  
    &rarr; jetzt steuert programmierprozess
- Deployments und server
    - Kompatibilit&auml;t herstellen
    
Architekten freuen sich am meisten &uuml;ber Modulkonzept, da Umsetzung von Designs einfacher, sprechender, direkter abgebildet

### Urspr&uuml;ngliche Motivation
- java standard lib zu gro&szlig;, monolithisch
- `@deprecated` bestandteile k&ouml;nnte man in optionales deprecated-module auslagern
- Module k&ouml;nnten nach Nutzen herangezogen werden  
&rarr; Java9 &rarr; rt.jar &rarr; `java.base`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&rarr; javafx  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&rarr;  ...  
- Achtung: noch viele Abh&auml;ngigkeiten vorhanden. Module nicht einfach herauswerfbar  
&rarr; Reines `java.base` projekt noch unrealistisch  
&rarr; `java.base` nach wie vor relativ dick, aber immerhin: oberfl&auml;chen raus, xml raus, DB raus, etc. etc.

#### Abw&auml;rtskompatibilit&auml;t gew&auml;hrleisten
- Jedes module kann als normales archive genutzt werden. .jar sieht man nicht direkt an ob modularisierung
    - `xy.jar` &rarr; CLASSPATH = normales archiv
    - `xy.jar` &rarr; MODULE_PATH = module
- wenn als library gewollt &rarr; einfach in den classpath stecken
- archiv das nicht modular konzipiert ist kann nicht in den modulpfad

Alle CLASSPATH archive bilden zusammen das "Anonyme Modul"

### Was kann ein Modul?
- pakete "exportieren"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&rarr; `export`
- andere module "anfordern"&nbsp;&rarr; `require`  

Das anonyme Modul exportiert "alles" und ben&ouml;tigt "alles" &rarr; selbes Verhalten wie vor j9, was im classpath steht habe ich

### Technisches Konzept:
Module classloader
- jeder classloader gibt nur die klassen nach au&szlig;en, die er in der `module-info.java` findet
- classloader kennt eigene jar (und classes) und "kennt die anderen" required classloader (nicht deren klassen)!
- vorteil: zur compile time alle referenzen bekannt, errors einfach anzeigbar
- (alles auch vorher m&ouml;glich, aber mehr hacking)
- classpath erh&auml;lt classpath-classloader

#### Implementierung:
- `java.base` ist das standard requirement, per default required, sofort verf&uuml;gbar
- system library komponenten sind jetzt **Module**, nicht alle einfach so verf&uuml;gbar
- das zweite modul, das **immer** implizit required ist, ist das anonyme modul (alles aus dem classpath)
- Achtung: wenn 2 module dassselbe Package exporten, f&uuml;hrt ein require f&uuml;r beide module zum compiler error!

#### Kapselung
- Module sind zus&auml;tzliche ebene der kapselung
- module k&ouml;nnen pakete exportieren &rarr; `export <package-name>`
- module k&ouml;nnen andere module anfordern &rarr; `requires <module-name>`
- export kann spezifizieren, an wen exportiert wird: `export <package-name> to <module-name>`
- requires kann spezifizieren werden: `requires transitive`
- Projekte k&ouml;nnen komplett inhaltlos sein, und NUR eine module-info enthalten &rarr; transitive Abh&auml;ngigkeiten etc. verkapseln
- Anmerkung: Ein Jigsaw Modul hat keinen lifecycle. M&ouml;chte ich wissen wann mein Modul (de)aktiviert wird? &rarr; static initialiser block

#### Modulkonzept & ServiceLoader
module-info.java
~~~java
provides <interfacename> with <implementationname>, <implementationname>,...
uses <interfacename>
~~~
ServiceLoader direkt typified auf das Interface, liefert die Impls aus "with", wirft exception wenn kein "uses" deklariert

#### Reflections
- `opens` in der `module-info.java` &rarr; Java Reflections zugriff
- Module als neuer Typ, ab sofort:
~~~
Module m = obj.getClass().getModule();
~~~
&rarr; enth&auml;lt classloader, Klassenname etc.
~~~  
ModuleDescriptor descriptor = obj.getClass().getModule().getModuleDescriptor();
~~~
&rarr; zur Laufzeit Zugriff auf das module-info.java und Infos darin  

Beispiel: statt `getResourcesAsStream` k&ouml;nnte man &uuml;ber das Modul arbeiten  
*Note*: Auf `.getModule()` k&ouml;nnen auch die Annotations gefunden werden, man k&ouml;nnte behaviour nach annotation speccen

## Sprachumfang: Neuerungen in Java
- Abstrakte Klassen vom Diamond ableiten
```java
List<String> names = new ArrayList<>() {...}
```
- try with resources, resource kann au&szlig;erhalb der Klammer deklariert werden, Resource references
- `private` methods in interfaces  
&rarr; Abstrakte Klassen verschwimmen, behalten aber nach wie vor Daseinsberechtigung
- Erweiterte Klassenbibliothek
    - Factory Methoden f&uuml;r Set, List, Map
    - Stream-Konzept erweitert
        - `takeWhile`, `takeOne` etc.
        - Optionals liefern jetzt auch einen Stream (Optionals &uuml;ber Stream auswerten m&ouml;glich)
    - Neue Logging API
        - `System.Logger`
        - relativ schlank
    - StackWalker
        - Wo befinde ich mich in der Aufrufs-Hierarchie? 
        - Performance-unkritisch, `native` Implementierung statt Exception zu werfen und direkt catchen
    - Die Klasse `Process` ist deutlich erweitert worden
        - Liefert jetzt deutlich mehr Informationen &uuml;ber den Process, externe Process Calls werden realistischer
        - Callbacks bei Prozess-Terminierung
    - `CompletableFuture` ist erweitert worden
        - `Future` ist ein Wrapper um ein "zuk&uuml;nftiges" Ergebnis
        - `.get()` ist blockierend bis Ergebnis eintrifft
        - bildet Workflows ab, Sequenz von asynchronen Vorg&auml;ngen
            ~~~java
            CompletableFuture cf1 = ...;
            CompletableFuture cf2 = cf1.then(...);
            ~~~
        - Abbildung war prinzipiell bereits in Java8 so gedacht, API noch nicht durchgedacht
### Neue Flow API
- Publisher, Subscription, Subscriber
- Noch etwas besser entkoppelt als Observer-Pattern durch Subscription
- Subscription asynchron ohne zutun des Programmierers
- `Publisher` &rarr; `Subscription` &larr; `WorkerThread` &rarr; `Subscriber`
- Reactive programming

### Werkzeuge
#### Werkzeuge im JDK
- Interner HTTP-Server unterst&uuml;tzt nun HTTP2
- *Flightrecorder*<sup>[1](#foot1)</sup> ist nun offizieller Bestandteil der JRE, nicht mehr hinter der Lizenz
- *jshell* eingef&uuml;hrt (Kommandozeile f&uuml;r schnelles Java Testing/"Hacking"/"Scripting", ohne `public class Main`, `public static void main()` declarations etc.)
- *jdep* eingef&uuml;hrt (Dependency Analyse)
- *jlink* eingef&uuml;hrt (Image der Applikation f&uuml;r deployment, linking von libs)

#### Stand der Community f&uuml;r Java9
- Spring/Hibernate etc. nicht stark betroffen, prim&auml; ohne gro&szlig;en Aufwand betroffen
    - Modularisierung: Communities sind in Portierung gestartet, haben aber keine Eile
- Java9 bringt außer Modularisierung wenig Druck zu Umstellung aus architektureller/struktureller Sicht, anders als Java8, das direkt die "Philosophie" von Dingen wie Spring Templates beeinflusst
- Apache Group &rarr; Portierung in fernerer Zukunft
- Maven Repositories &rarr; keine Auswirkungen
- Build-Werkzeuge &rarr; In Arbeit, Auswirkungen durch Modularisierung, Prozesse werden wohl viel Nacharbeit erfordern
- Applikationsserver &rarr; In Arbeit
    - &Auml;ltere Versionen laufen zwar ziemlich sicher auch unter Java9 JVM, aber Modularisierung k&ouml;nnte gro&szlig;e Vorteile schaffen, Updates sind wahrscheinlich
    - JEE Spezifikation k&ouml;nnte durch Altlasten nicht einfach erweiterbar sein, evtl. gr&ouml;&szlig;ere Umstellung kommend
- Oracle: neue Release-Politik, evtl. Release ca. alle &frac12; Jahre? St&auml;rkere Community-Einbindung

## Fragerunde
- Umstieg jetzt? 
> Build Tools als erstes analysieren. Dann durchaus modules einführen
- `module-info.java`, Komplexität und Best Practices?
> Meist sehr übersichtlich, aber projekt kann durchaus 10-20 exports haben
> * Frage ist stets: wer ist zuständig, wer macht die dependencies wie? Requires könnten theoretisch für Komplexität sorgen
> * Involvierung des Build-Tools klären
- Zusammenhang Aggregat-poms?
> Ein Maven Aggregat ist auch ein module aggregat, Komplexität der dependencies spiegelt sich in Modul-Granularität wieder 
- Benennung der Module? Projektname = Modulname?
> Voll qualifizieren durchaus empfehlenswert für Eindeutigkeit. Kann für Lesbarkeit aber auch verzichtet werden. Modulname convention ist: lowercase
> Sprechende Namsgebung wird durch Module **noch** wichtiger
- Buchempfehlungen?
> Keine. Zu Modulkonzepten gibt es bereits derart viel Erfahrung und Diskussionstiefe, dass Literatur dort interessant sein kann. Aber nichts speziell auf Java9 bezogen


<sup><a name="foot1">1</a></sup>: Metrikinformationen der Aufrufstatistiken der JVM, wie lange haben welche Aufrufe gedauert
