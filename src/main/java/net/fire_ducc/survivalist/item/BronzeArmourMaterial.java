package net.fire_ducc.survivalist.item;

import net.fire_ducc.survivalist.Survivalist;
import net.fire_ducc.survivalist.tag.ModItemTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class BronzeArmourMaterial {
    public static final int BASE_DURABILITY = 12;
    public static final RegistryKey<EquipmentAsset> BRONZE_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Survivalist.MOD_ID, "bronze"));
    private static final TagKey<Item> REPAIRS_BRONZE_ARMOUR = ModItemTagProvider.REPAIRS_BRONZE;
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 5,
                    EquipmentType.LEGGINGS, 4,
                    EquipmentType.BOOTS, 2
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_BRONZE_ARMOUR,
            BRONZE_ARMOR_MATERIAL_KEY
    );
}
