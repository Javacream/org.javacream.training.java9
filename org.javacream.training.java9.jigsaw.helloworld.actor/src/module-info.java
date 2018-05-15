import org.javacream.training.java9.jigsaw.helloworld.HelloWorld;

/**
 * 
 */
/**
 * @author Rainer Sawitzki
 *
 */
module org.javacream.training.java9.jigsaw.helloworld.actor {
	requires org.javacream.training.java9.jigsaw.helloworld.api;
	uses HelloWorld;
}