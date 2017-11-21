import org.javacream.training.java9.command.api.Command;

/**
 * 
 */
/**
 * @author Administrator
 *
 */
module org.javacream.training.java9.command.impl2 {
	requires org.javacream.training.java9.command.api;
	provides Command with org.javacream.training.java9.command.impl2.CommandImpl2;
}