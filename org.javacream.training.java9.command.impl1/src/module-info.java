import org.javacream.training.java9.command.api.Command;

/**
 * 
 */
/**
 * @author Administrator
 *
 */
module org.javacream.training.java9.command.impl1 {
	requires org.javacream.training.java9.command.api;
	provides Command with org.javacream.training.java9.command.impl1.CommandImpl1a,org.javacream.training.java9.command.impl1.CommandImpl1b;
}