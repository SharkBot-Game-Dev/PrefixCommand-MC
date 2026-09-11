# PrefixCommand-MC
Prefixコマンドを簡単に実装できるMinecraftJavaMod

# セットアップ
<a href="https://github.com/SharkBot-Game-Dev/PrefixCommand-MC/releases/latest">ここから</a> 最新の.jarをダウンロードし、<br>
libフォルダに配置します。（ない場合は作成）<br>
build.gradleのdependenciesに以下を追加します。<br>
```
compileOnly fileTree(dir: 'lib', include: ['*.jar'])
```

# コマンドを作成する
以下は、サンプルコマンドを作成するサンプルコードです。
```
package org.shark.examplePrefixcommand.client.Commands;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.shark.prefixcommand.client.Command;
import org.shark.prefixcommand.client.CommandArg;

import java.util.Map;

public class helloCommand extends Command {
    public helloCommand() {
        commandName = "hello";
        commandDescription = "こんにちは！世界！";
    }

    @Override
    public void execute(Map<Integer, CommandArg> commandArgs) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;
        player.sendSystemMessage(Component.literal("こんにちは！世界！"));
    }
}

```