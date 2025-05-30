package io.github.thebusybiscuit.electricspawners.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class TextUtils {
    static MiniMessage miniMessage = MiniMessage.builder()
            .tags(
                    TagResolver.resolver(
                            TagResolver.standard()
                    )
            )
            .build();

    public static Component toComponent(String content, TagResolver... placeholders) {
        return Component.empty().decoration(TextDecoration.ITALIC, false).append(miniMessage.deserialize(content, placeholders));
    }

    public static String colorify(String content) {
        return ChatColor.translateAlternateColorCodes('&', content);
    }

    public static String capitalize(String content) {
        return String.join(" ", Arrays.stream(content.split(" ")).map(text -> text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase()).toList());
    }
}
