package net.fire_ducc.survivalist.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fire_ducc.survivalist.Survivalist;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider<Block> {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    public static final TagKey<Block> INCORRECT_FOR_BRONZE = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Survivalist.MOD_ID, "incorrect_for_bronze_tool"));
    public static final TagKey<Block> INCORRECT_FOR_COPPER = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Survivalist.MOD_ID, "incorrect_for_copper_tool"));


    protected TagBuilder valueLookupBuilder(TagKey<Block> tag) {
        return super.getTagBuilder(tag);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

    }

}
