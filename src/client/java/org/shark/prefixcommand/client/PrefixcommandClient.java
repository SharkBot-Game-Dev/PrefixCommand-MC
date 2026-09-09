package org.shark.prefixcommand.client;

import net.fabricmc.api.ClientModInitializer;
import org.shark.prefixcommand.client.defaultCommand.testCommand;

public class PrefixcommandClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Commands.registerPrefix("!");
        Commands.registerCommand("!", new testCommand());
    }
}
