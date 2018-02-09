import org.javacream.training.java9.jigsaw.publisher.StringSubscriber;
import org.javacream.training.java9.jigsaw.subscriber1.SimpleSubscriber1;

/**
 * 
 */
/**
 * @author Administrator
 *
 */
module org.javacream.training.java9.jigsaw.subscriber1 {
	requires org.javacream.training.java9.jigsaw.publisher;
	provides StringSubscriber with SimpleSubscriber1;

}