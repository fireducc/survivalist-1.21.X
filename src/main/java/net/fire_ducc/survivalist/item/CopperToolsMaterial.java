package net.fire_ducc.survivalist.item;

import net.fire_ducc.survivalist.tag.ModBlockTagProvider;
import net.fire_ducc.survivalist.tag.ModItemTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;

public class CopperToolsMaterial {

    private static final TagKey<Item> REPAIRS_COPPER_TOOLS = ModItemTagProvider.REPAIRS_COPPER;
    public static final ToolMaterial COPPER_TOOL_MATERIAL = new ToolMaterial(
            ModBlockTagProvider.INCORRECT_FOR_COPPER,
            175,
            5.0F,
            1.0F,
            10,
            CopperToolsMaterial.REPAIRS_COPPER_TOOLS
    );
}
