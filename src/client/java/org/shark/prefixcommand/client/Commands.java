package org.shark.prefixcommand.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commands {
    public static List<String> prefixes = new ArrayList<>();
    public static Map<String, Map<String, Command>> commands = new HashMap<>();

    public static void registerPrefix(String prefix) {
        prefixes.add(prefix);
    }

    public static void registerCommand(String prefix, Command command) {
        Map<String, Command> commandsMap = commands.get(prefix);
        if (commandsMap == null) {
            commandsMap = new HashMap<>();
            commandsMap.put(command.commandName, command);
            commands.put(prefix, commandsMap);
        } else {
            commandsMap.put(command.commandName, command);
            commands.put(prefix, commandsMap);
        }
    }
}
