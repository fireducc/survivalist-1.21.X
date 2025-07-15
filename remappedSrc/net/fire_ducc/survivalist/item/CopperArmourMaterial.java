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

public class CopperArmourMaterial {
    public static final int BASE_DURABILITY = 8;
    public static final RegistryKey<EquipmentAsset> COPPER_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Survivalist.MOD_ID, "copper"));
    private static final TagKey<Item> REPAIRS_COPPER_ARMOUR = ModItemTagProvider.REPAIRS_COPPER;
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 1,
                    EquipmentType.CHESTPLATE, 3,
                    EquipmentType.LEGGINGS, 2,
                    EquipmentType.BOOTS, 1
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_COPPER_ARMOUR,
            COPPER_ARMOR_MATERIAL_KEY
    );
}
