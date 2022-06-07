package com.github.u9g.u9gutils;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MoreItemUtils {
    public static ItemStack firstNonEmpty(Inventory inv) {
        var iter = inv.iterator();
        ItemStack item;
        while ((item = iter.next()) == null && iter.hasNext());
        return item;
    }
}
