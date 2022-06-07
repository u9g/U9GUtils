package com.github.u9g.u9gutils;
import com.manya.pdc.DataTypes;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.*;

import java.time.Instant;
import java.util.*;

public class NBTUtil {
    private static final PersistentDataType<?, List<UUID>> UUID_LIST = DataTypes.list(DataTypes.UUID);

    public static void set (PersistentDataHolder pdh, NamespacedKey key, boolean value) {
        pdh.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte)(value ? 1 : 0));
    }

    public static void set (PersistentDataHolder pdh, NamespacedKey key, UUID value) {
        pdh.getPersistentDataContainer().set(key, DataTypes.UUID, value);
    }

    public static void set (PersistentDataHolder pdh, NamespacedKey key, String value) {
        pdh.getPersistentDataContainer().set(key, PersistentDataType.STRING, value);
    }

    public static void set(PersistentDataHolder pdh, NamespacedKey key, int value) {
        pdh.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, value);
    }

    public static void set(PersistentDataHolder pdh, NamespacedKey key, long value) {
        pdh.getPersistentDataContainer().set(key, PersistentDataType.LONG, value);
    }

    public static void set(PersistentDataHolder pdh, NamespacedKey key, float value) {
        pdh.getPersistentDataContainer().set(key, PersistentDataType.FLOAT, value);
    }

    public static void set(PersistentDataHolder pdh, NamespacedKey key, double value) {
        pdh.getPersistentDataContainer().set(key, PersistentDataType.DOUBLE, value);
    }

    public static void set(PersistentDataHolder pdh, NamespacedKey key, byte[] value) {
        pdh.getPersistentDataContainer().set(key, PersistentDataType.BYTE_ARRAY, value);
    }

    public static void set(PersistentDataHolder pdh, NamespacedKey key, Instant value) {
        pdh.getPersistentDataContainer().set(key, DataTypes.INSTANT, value);
    }

    public static void set(PersistentDataHolder pdh, NamespacedKey key, List<UUID> value) {
        pdh.getPersistentDataContainer().set(key, UUID_LIST, value);
    }

    public static void set(PersistentDataHolder pdh, NamespacedKey key, ItemStack value) {
        pdh.getPersistentDataContainer().set(key, PersistentDataType.BYTE_ARRAY, value.serializeAsBytes());
    }

    public static Optional<Boolean> getAsBoolean (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, PersistentDataType.BYTE);
        return result == null ? Optional.empty() : Optional.of(result == 1);
    }

    public static Optional<UUID> getAsUUID (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, DataTypes.UUID);
        return result == null ? Optional.empty() : Optional.of(result);
    }

    public static Optional<String> getAsString (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, PersistentDataType.STRING);
        return result == null ? Optional.empty() : Optional.of(result);
    }

    public static OptionalInt getAsInt (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
        return result == null ? OptionalInt.empty() : OptionalInt.of(result);
    }

    public static OptionalLong getAsLong (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, PersistentDataType.LONG);
        return result == null ? OptionalLong.empty() : OptionalLong.of(result);
    }

    public static Optional<Float> getAsFloat (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, PersistentDataType.FLOAT);
        return result == null ? Optional.empty() : Optional.of(result);
    }

    public static OptionalDouble getAsDouble (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, PersistentDataType.DOUBLE);
        return result == null ? OptionalDouble.empty() : OptionalDouble.of(result);
    }

    public static Optional<byte[]> getAsBytes (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, PersistentDataType.BYTE_ARRAY);
        return result == null ? Optional.empty() : Optional.of(result);
    }

    public static Optional<Instant> getAsInstant (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, DataTypes.INSTANT);
        return result == null ? Optional.empty() : Optional.of(result);
    }

    public static Optional<List<UUID>> getAsUUIDList (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, UUID_LIST);
        return result == null ? Optional.empty() : Optional.of(result);
    }

    public static Optional<ItemStack> getAsItemStack (PersistentDataHolder pdh, NamespacedKey key) {
        var result = pdh.getPersistentDataContainer().get(key, PersistentDataType.BYTE_ARRAY);
        return result == null ? Optional.empty() : Optional.of(ItemStack.deserializeBytes(result));
    }

    public static boolean has (PersistentDataHolder pdh, NamespacedKey key) {
        return pdh.getPersistentDataContainer().has(key);
    }
}
