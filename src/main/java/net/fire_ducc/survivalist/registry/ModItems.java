package net.fire_ducc.survivalist.registry;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fire_ducc.survivalist.item.BronzeArmourMaterial;
import net.fire_ducc.survivalist.item.CopperArmourMaterial;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

import static net.fire_ducc.survivalist.item.BronzeToolsMaterial.BRONZE_TOOL_MATERIAL;
import static net.fire_ducc.survivalist.item.CopperToolsMaterial.COPPER_TOOL_MATERIAL;
import static net.minecraft.item.Items.register;


public class ModItems {
    public static final Item FOX_HIDE = register("fox_hide", Item::new, new Item.Settings());
    public static final Item RAW_TIN = register("raw_tin", Item::new, new Item.Settings());
    public static final Item COPPER_NUGGET = register("copper_nugget", Item::new, new Item.Settings());
    public static final Item BRONZE_NUGGET = register("bronze_nugget", Item::new, new Item.Settings());
    public static final Item TIN_NUGGET = register("tin_nugget", Item::new, new Item.Settings());
    public static final Item TIN_INGOT = register("tin_ingot", Item::new, new Item.Settings());
    public static final Item BRONZE_INGOT = register("bronze_ingot", Item::new, new Item.Settings());

    public static final Item COPPER_SWORD = register("copper_sword", Item::new, new Item.Settings().sword(COPPER_TOOL_MATERIAL, 3.3f, -2.4f));
    public static final Item COPPER_PICKAXE = register("copper_pickaxe", Item::new, new Item.Settings().pickaxe(COPPER_TOOL_MATERIAL, 1.0f, -2.8f));
//    public static final Item COPPER_SHOVEL = register("copper_shovel", Item::new, new Item.Settings().shovel(COPPER_TOOL_MATERIAL, 1.5f, -3.0f));
//    public static final Item COPPER_HOE = register("copper_hoe", Item::new, new Item.Settings().hoe(COPPER_TOOL_MATERIAL, -1.0f, -2.0f));
//    public static final Item COPPER_AXE = register("copper_axe", Item::new, new Item.Settings().axe(COPPER_TOOL_MATERIAL, 6.5f, -3.0f));

    public static final Item COPPER_SHOVEL = register(
            "copper_shovel",
            settings -> new ShovelItem(COPPER_TOOL_MATERIAL, 1.5f, -3.0f, settings),
            new Item.Settings()
    );
    public static final Item COPPER_HOE = register(
            "copper_hoe",
            settings -> new HoeItem(COPPER_TOOL_MATERIAL, -1.0f, -2.0f, settings),
            new Item.Settings()
    );
    public static final Item COPPER_AXE = register(
            "copper_axe",
            settings -> new AxeItem(COPPER_TOOL_MATERIAL, 6.5f, -3.0f, settings),
            new Item.Settings()
    );

    public static final Item BRONZE_SWORD = register("bronze_sword", Item::new, new Item.Settings().sword(BRONZE_TOOL_MATERIAL, 3.3f, -2.4f));
    public static final Item BRONZE_PICKAXE = register("bronze_pickaxe", Item::new, new Item.Settings().pickaxe(BRONZE_TOOL_MATERIAL, 1.0f, -2.8f));

    public static final Item BRONZE_SHOVEL = register(
            "bronze_shovel",
            settings -> new ShovelItem(BRONZE_TOOL_MATERIAL, 1.5f, -3.0f, settings),
            new Item.Settings()
    );
    public static final Item BRONZE_HOE = register(
            "bronze_hoe",
            settings -> new HoeItem(BRONZE_TOOL_MATERIAL, -1.0f, -2.0f, settings),
            new Item.Settings()
    );
    public static final Item BRONZE_AXE = register(
            "bronze_axe",
            settings -> new AxeItem(BRONZE_TOOL_MATERIAL, 6.2f, -3.0f, settings),
            new Item.Settings()
    );
//    public static final Item BRONZE_SHOVEL = register("bronze_shovel", Item::new, new Item.Settings().shovel(BRONZE_TOOL_MATERIAL, 1.5f, -3.0f));
//    public static final Item BRONZE_HOE = register("bronze_hoe", Item::new, new Item.Settings().hoe(BRONZE_TOOL_MATERIAL, -1.0f, -2.0f));
//    public static final Item BRONZE_AXE = register("bronze_axe", Item::new, new Item.Settings().axe(BRONZE_TOOL_MATERIAL, 6.2f, -3.0f));

    public static final Item COPPER_HELMET = register("copper_helmet", Item::new, new Item.Settings().armor(CopperArmourMaterial.INSTANCE, EquipmentType.HELMET).rarity(Rarity.COMMON));
    public static final Item COPPER_CHESTPLATE = register("copper_chestplate", Item::new, new Item.Settings().armor(CopperArmourMaterial.INSTANCE, EquipmentType.CHESTPLATE).rarity(Rarity.COMMON));
    public static final Item COPPER_LEGGINGS = register("copper_leggings", Item::new, new Item.Settings().armor(CopperArmourMaterial.INSTANCE, EquipmentType.LEGGINGS).rarity(Rarity.COMMON));
    public static final Item COPPER_BOOTS = register("copper_boots", Item::new, new Item.Settings().armor(CopperArmourMaterial.INSTANCE, EquipmentType.BOOTS).rarity(Rarity.COMMON));

    public static final Item BRONZE_HELMET = register("bronze_helmet", Item::new, new Item.Settings().armor(BronzeArmourMaterial.INSTANCE, EquipmentType.HELMET).rarity(Rarity.COMMON));
    public static final Item BRONZE_CHESTPLATE = register("bronze_chestplate", Item::new, new Item.Settings().armor(BronzeArmourMaterial.INSTANCE, EquipmentType.CHESTPLATE).rarity(Rarity.COMMON));
    public static final Item BRONZE_LEGGINGS = register("bronze_leggings", Item::new, new Item.Settings().armor(BronzeArmourMaterial.INSTANCE, EquipmentType.LEGGINGS).rarity(Rarity.COMMON));
    public static final Item BRONZE_BOOTS = register("bronze_boots", Item::new, new Item.Settings().armor(BronzeArmourMaterial.INSTANCE, EquipmentType.BOOTS).rarity(Rarity.COMMON));


    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("survivalist", path));
        return Items.register(registryKey, factory, settings);
    }
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.RABBIT_HIDE, FOX_HIDE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.STONE_SWORD, COPPER_SWORD, BRONZE_SWORD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.LEATHER_BOOTS, COPPER_HELMET, COPPER_CHESTPLATE, COPPER_LEGGINGS, COPPER_BOOTS, BRONZE_HELMET, BRONZE_CHESTPLATE, BRONZE_LEGGINGS, BRONZE_BOOTS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.STONE_HOE, COPPER_SHOVEL, COPPER_PICKAXE, COPPER_AXE, COPPER_HOE, BRONZE_SHOVEL, BRONZE_PICKAXE, BRONZE_AXE, BRONZE_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.RAW_COPPER, RAW_TIN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.IRON_NUGGET, COPPER_NUGGET, TIN_NUGGET, BRONZE_NUGGET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.COPPER_INGOT, TIN_INGOT, BRONZE_INGOT);
        });
    }

}
