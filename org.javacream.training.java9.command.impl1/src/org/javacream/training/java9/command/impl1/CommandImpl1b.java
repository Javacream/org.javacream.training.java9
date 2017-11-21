package org.javacream.training.java9.command.impl1;

import org.javacream.training.java9.command.api.Command;

public class CommandImpl1b implements Command {

	@Override
	public String getDescription() {
		return "impl1b";
	}

	@Override
	public String execute() {
		return "executed impl1b";
	}

}
