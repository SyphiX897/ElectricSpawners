package io.github.thebusybiscuit.electricspawners.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemUtils {
    public static ItemStack itemStack(Material type, String name, String... lore) {
        ItemStack itemStack = new ItemStack(type);
        itemStack.editMeta(meta -> {
            meta.setDisplayName(TextUtils.colorify(name));
            meta.setLore(Arrays.stream(lore).map(TextUtils::colorify).toList());
        });

        return itemStack;
    }

    public static ItemStack itemStack(ItemStack item, String name, String... lore) {
        item.editMeta(meta -> {
            meta.setDisplayName(TextUtils.colorify(name));
            meta.setLore(Arrays.stream(lore).map(TextUtils::colorify).toList());
        });

        return item;
    }
}
