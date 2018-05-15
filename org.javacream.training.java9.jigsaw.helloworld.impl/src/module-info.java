import org.javacream.training.java9.jigsaw.helloworld.HelloWorld;
import org.javacream.training.java9.jigsaw.helloworld.impl.ConsoleHelloWorld;

/**
 * 
 */
/**
 * @author Rainer Sawitzki
 *
 */
module org.javacream.training.java9.jigsaw.helloworld.impl {
	requires commons.logging;
	requires org.javacream.training.java9.jigsaw.helloworld.api;
	provides HelloWorld with ConsoleHelloWorld;
}