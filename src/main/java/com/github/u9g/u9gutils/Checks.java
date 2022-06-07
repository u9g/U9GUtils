package com.github.u9g.u9gutils;

import org.bukkit.NamespacedKey;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Checks {
    public static boolean openingBlock (PlayerInteractEvent event) {
        return event.getClickedBlock() != null &&
                event.getAction().equals(Action.RIGHT_CLICK_BLOCK) &&
                !event.getPlayer().isSneaking();
    }
}
