import org.javacream.training.java9.jigsaw.publisher.StringSubscriber;
import org.javacream.training.java9.jigsaw.subscriber2.SimpleSubscriber2;

/**
 * 
 */
/**
 * @author Administrator
 *
 */
module org.javacream.training.java9.jigsaw.subscriber2 {

	requires org.javacream.training.java9.jigsaw.publisher;
	provides StringSubscriber with SimpleSubscriber2;
}