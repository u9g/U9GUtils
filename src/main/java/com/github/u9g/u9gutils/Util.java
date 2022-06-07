package com.github.u9g.u9gutils;

import com.google.common.base.Preconditions;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Util {
    public static Component mm (String s) {
        return MiniMessage.miniMessage().deserialize(s);
    }
    private static final Map<String, NamespacedKey> cachedKeys = new MaxSizeHashMap<>(500);

//    public static NamespacedKey nsKeyFor(Block block, String prefix) {
//        Preconditions.checkArgument(!Objects.isNull(block));
//        if (cachedKeys.containsKey(block)) return cachedKeys.get(block);
//        var location = block.getLocation();
//        var lowestX = location.getBlockX() & 15; // same as % 16
//        var lowestZ = location.getBlockZ() & 15; // same as % 16
//        var relX = location.getX() - lowestX;
//        var relZ = location.getZ() - lowestZ;
//        cachedKeys.put(block, NamespacedKey.fromString(prefix + "-" + relX + "-" + location.getBlockY() + "-" + relZ));
//        return nsKeyFor(block, prefix);
//    }

    public static NamespacedKey key(String name) {
        if (cachedKeys.containsKey(name)) return cachedKeys.get(name);
        cachedKeys.put(name, NamespacedKey.fromString(name));
        return key(name);
    }
}

