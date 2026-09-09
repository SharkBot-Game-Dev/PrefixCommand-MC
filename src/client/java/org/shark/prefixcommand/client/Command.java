package org.shark.prefixcommand.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Command {
    private static final Logger log = LoggerFactory.getLogger(Command.class);
    public String commandName;
    public String commandDescription;
    public Map<Integer, CommandArg> commandArgs = new HashMap<>();

    public Command() {

    }

    public void commandError(Exception exception) {
        log.error("{} Error: ", commandName, exception);
    }

    public void commandExecute(Map<Integer, CommandArg> commandArgs) {
        return;
    }

    public void execute(Map<Integer, CommandArg> commandArgs) {
        try {
            commandExecute(commandArgs);
        } catch (Exception e) {
            commandError(e);
        }
    }

    public String getCommandName() {
        return commandName;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public Map<Integer, CommandArg> getCommandArgs() {
        return commandArgs;
    }
}
