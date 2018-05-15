import org.javacream.training.java9.jigsaw.publisher.StringSubscriber;

/**
 * 
 */
/**
 * @author Administrator
 *
 */
module org.javacream.training.java9.jigsaw.application {
	requires org.javacream.training.java9.jigsaw.publisher;
	uses StringSubscriber;
}