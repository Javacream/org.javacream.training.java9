package org.javacream.training.java9.command.appl;

import java.util.ServiceLoader;

import org.javacream.training.java9.command.api.Command;

public class CommandApplication {

	public static void main(String[] args) {
		ServiceLoader<Command> serviceLoader = ServiceLoader.load(Command.class);
		serviceLoader.forEach((command) -> System.out.println(command.getDescription()));
	}

}
