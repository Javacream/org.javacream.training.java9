package org.javacream.training.java9.command.impl2;

import org.javacream.training.java9.command.api.Command;

public class CommandImpl2 implements Command {

	@Override
	public String getDescription() {
		return "impl2";
	}

	@Override
	public String execute() {
		return "executed impl2";
	}

}
