package com.github.u9g.u9gutils;

import com.destroystokyo.paper.profile.ProfileProperty;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class ItemBuilder {
    ItemStack item;

    public static ItemBuilder of (Material material) {
        return ItemBuilder.from(new ItemStack(material));
    }

    public static ItemBuilder from (ItemStack itemStack) {
        return new ItemBuilder(itemStack);
    }

    private ItemBuilder(ItemStack itemStack) {
        item = itemStack;
    }

    public ItemBuilder count (int count) {
        item.setAmount(count);
        return this;
    }

    public ItemBuilder customModelData (int data) {
        setItemMeta(c -> c.setCustomModelData(data));
        return this;
    }

    public ItemBuilder name (Component component) {
        setItemMeta(im -> {
            Component c = component.colorIfAbsent(NamedTextColor.WHITE);
            if (!c.hasDecoration(TextDecoration.ITALIC)) {
                c = c.decoration(TextDecoration.ITALIC, false);
            }
            im.displayName(c);
        });
        return this;
    }

    public ItemBuilder lore (List<Component> components) {
        setItemMeta(im -> im.lore(components.stream().map(c -> {
            c = c.colorIfAbsent(NamedTextColor.WHITE);
            if (!c.hasDecoration(TextDecoration.ITALIC)) {
                c = c.decoration(TextDecoration.ITALIC, false);
            }
            return c;
        }).toList()));
        return this;
    }

    public ItemBuilder setItemFlags (ItemFlag... flags) {
        setItemMeta(im -> im.addItemFlags(flags));
        return this;
    }

    public ItemBuilder toggleUnbreakable () {
        setItemMeta(im -> im.setUnbreakable(!im.isUnbreakable()));
        return this;
    }

    public ItemBuilder setHeadSkin (String texture) {
        setItemMeta(im -> {
            if (this.item.getType().equals(Material.PLAYER_HEAD) && im instanceof SkullMeta sm) {
                var profile = Bukkit.createProfile(UUID.randomUUID());
                profile.setProperty(new ProfileProperty("textures", texture));
                sm.setPlayerProfile(profile);
            } else throw new Error("Not a player head");
        });
        return this;
    }

    public ItemBuilder enchant (Enchantment enchantment, int level) {
        setItemMeta(im -> {
            if (im.hasItemFlag(ItemFlag.HIDE_ENCHANTS))
                im.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addEnchant(enchantment, level, true);
        });
        return this;
    }

    public ItemBuilder attribute (Attribute attr, AttributeModifier.Operation mod, double amount) {
        setItemMeta(im -> {
            im.addAttributeModifier(attr, new AttributeModifier(UUID.randomUUID(), attr.translationKey(), amount, mod, EquipmentSlot.HAND));
        });
        return this;
    }

    private void setItemMeta (Consumer<ItemMeta> consumer) {
        consumer.andThen(im -> item.setItemMeta(im)).accept(item.getItemMeta());
    }

    public ItemBuilder set (@NotNull NamespacedKey key, @NotNull String value) {
        ItemMeta im = item.getItemMeta();
        NBTUtil.set(im, key, value);
        item.setItemMeta(im);
        return this;
    }

    public ItemBuilder set (@NotNull NamespacedKey key, int value) {
        ItemMeta im = item.getItemMeta();
        NBTUtil.set(im, key, value);
        item.setItemMeta(im);
        return this;
    }

    public ItemBuilder set (@NotNull NamespacedKey key, double value) {
        ItemMeta im = item.getItemMeta();
        NBTUtil.set(im, key, value);
        item.setItemMeta(im);
        return this;
    }

    public ItemBuilder set (@NotNull NamespacedKey key, float value) {
        ItemMeta im = item.getItemMeta();
        NBTUtil.set(im, key, value);
        item.setItemMeta(im);
        return this;
    }

    public ItemBuilder set (@NotNull NamespacedKey key, long value) {
        ItemMeta im = item.getItemMeta();
        NBTUtil.set(im, key, value);
        item.setItemMeta(im);
        return this;
    }

    public ItemBuilder set (@NotNull NamespacedKey key, boolean value) {
        ItemMeta im = item.getItemMeta();
        NBTUtil.set(im, key, value);
        item.setItemMeta(im);
        return this;
    }

    public ItemStack build () {
        return item;
    }
}
