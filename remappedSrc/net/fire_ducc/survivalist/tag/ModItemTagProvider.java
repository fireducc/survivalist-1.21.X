package net.fire_ducc.survivalist.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fire_ducc.survivalist.Survivalist;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider<Item> {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.ITEM, registriesFuture);
	}

	public static final TagKey<Item> REPAIRS_COPPER = TagKey.of(RegistryKeys.ITEM, Identifier.of(Survivalist.MOD_ID, "repairs_copper_armor"));
	public static final TagKey<Item> REPAIRS_BRONZE = TagKey.of(RegistryKeys.ITEM, Identifier.of(Survivalist.MOD_ID, "repairs_bronze_armor"));

	protected TagBuilder valueLookupBuilder(TagKey<Item> tag) {
		return super.getTagBuilder(tag);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

	}
}
