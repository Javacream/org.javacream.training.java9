import org.javacream.training.java9.jigsaw.helloworld.HelloWorld;
import org.javacream.training.java9.jigsaw.helloworld.impl2.AlternativeConsoleHelloWorld;

/**
 * 
 */
/**
 * @author Rainer Sawitzki
 *
 */
module org.javacream.training.java9.jigsaw.helloworld.impl2 {
	requires commons.logging;
	requires org.javacream.training.java9.jigsaw.helloworld.api;
	provides HelloWorld with AlternativeConsoleHelloWorld;
}