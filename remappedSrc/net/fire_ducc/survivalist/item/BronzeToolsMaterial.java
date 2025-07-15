package net.fire_ducc.survivalist.item;

import net.fire_ducc.survivalist.tag.ModBlockTagProvider;
import net.fire_ducc.survivalist.tag.ModItemTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;

public class BronzeToolsMaterial {

    public static final TagKey<Item> REPAIRS_BRONZE_TOOLS = ModItemTagProvider.REPAIRS_BRONZE;

    public static final ToolMaterial BRONZE_TOOL_MATERIAL = new ToolMaterial(
            ModBlockTagProvider.INCORRECT_FOR_BRONZE,
            200,
            5.0F,
            1.5F,
            10,
            BronzeToolsMaterial.REPAIRS_BRONZE_TOOLS
    );
}
