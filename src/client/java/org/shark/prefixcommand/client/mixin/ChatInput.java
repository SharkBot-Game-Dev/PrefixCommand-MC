package org.shark.prefixcommand.client.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.network.chat.Component;
import org.shark.prefixcommand.client.Command;
import org.shark.prefixcommand.client.CommandArg;
import org.shark.prefixcommand.client.CommandArgParser;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ChatScreen.class)
public class ChatInput {

    @Inject(
            method = "handleChatInput",
            at = @At("HEAD"),
            cancellable = true
    )
    public void handleChatInput(
            String msg,
            final boolean addToRecent,
            CallbackInfo ci
    ) {
        if (msg.isEmpty()) {
            return;
        }
        CommandArgParser parser = new CommandArgParser();
        Command command = parser.parseCommand(msg);
        if (command == null) {
            // System.out.print(command);
            return;
        }
        // System.out.print(command);
        Map<Integer, CommandArg> commandArg = parser.parseArg(msg, command.commandArgs);
        // System.out.print(command.commandArgs);

        int reqArgsCount = 0;
        for (Map.Entry<Integer, CommandArg> entry : command.commandArgs.entrySet()) {
            if (entry.getValue().required) reqArgsCount += 1;
        }

        List<Integer> argsCount = commandArg.keySet().stream().toList();
        if (argsCount.size() < reqArgsCount) {
            Minecraft client = Minecraft.getInstance();
            if (client.player != null) {
                client.player.sendSystemMessage(Component.literal("引数が足りません！"));
            }
            ci.cancel();
            return;
        }

        command.execute(commandArg);
        ci.cancel();
    }
}