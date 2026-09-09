package org.shark.prefixcommand.client.defaultCommand;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.shark.prefixcommand.client.Command;
import org.shark.prefixcommand.client.CommandArg;

import java.util.HashMap;
import java.util.Map;

public class testCommand extends Command {
    public testCommand() {
        commandName = "test";
        commandDescription = "テストです！";
        commandArgs = new HashMap<>();

        CommandArg testArg = new CommandArg("test");
        testArg.required = true;
        commandArgs.put(0, testArg);

        CommandArg testArg2 = new CommandArg("test2");
        commandArgs.put(1, testArg2);
    }

    @Override
    public void execute(Map<Integer, CommandArg> commandArgs) {
        Minecraft client = Minecraft.getInstance();
        if (client.player != null) {
            client.player.sendSystemMessage(Component.literal("このコマンドはテストです！\n引数一覧: " + commandArgs.toString()));
        }
    }
}
