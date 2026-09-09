package org.shark.prefixcommand.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandArgParser {
    public Command parseCommand(String commandInput) {
        List<String> args = List.of(commandInput.split(" "));
        if (args.isEmpty()) {
            return null;
        }
        // System.out.print(args + "\n");
        String commandAndPrefix = args.getFirst();
        // System.out.print(commandAndPrefix + "\n" + Commands.prefixes + "\n");
        for (int i = 0; i < Commands.prefixes.size(); i++) {
            if (!commandAndPrefix.startsWith(Commands.prefixes.get(i))) continue;

            String commandName = commandAndPrefix.substring(Commands.prefixes.get(i).length());
            // System.out.print(commandName + "\n" + Commands.commands);
            return Commands.commands.get(Commands.prefixes.get(i)).get(commandName);
        }
        return null;
    }

    public Map<Integer, CommandArg> parseArg(
            String commandInput,
            Map<Integer, CommandArg> commandArgs
    ) {
        Map<Integer, CommandArg> mapArgs = new HashMap<>();

        if (commandInput == null || commandInput.isBlank()) {
            return mapArgs;
        }

        String[] args = commandInput.trim().split("\\s+");

        if (args.length <= 1) {
            return mapArgs;
        }

        System.out.print(Arrays.toString(args));

        for (int i = 1; i < args.length; i++) {
            int argIndex = i - 1;

            CommandArg commandArg = commandArgs.get(argIndex);
            System.out.print(argIndex + "\n" + commandArg);
            if (commandArg == null) {
                continue;
            }

            commandArg.argValue = args[i];
            mapArgs.put(argIndex, commandArg);
        }

        System.out.print(mapArgs);

        return mapArgs;
    }
}
