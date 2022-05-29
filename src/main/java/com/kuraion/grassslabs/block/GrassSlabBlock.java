
package com.kuraion.grassslabs.block;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.BiomeColors;

import java.util.List;
import java.util.Collections;

import com.kuraion.grassslabs.init.GrassslabsModBlocks;

public class GrassSlabBlock extends SlabBlock {
	public GrassSlabBlock() {
		super(Properties.of(Material.GRASS).sound(SoundType.GRASS).strength(0.6f, 0.6f).lightLevel(s -> 0));
		setRegistryName("grass_slab");
	}

	@Override
	public MaterialColor defaultMaterialColor() {
		return MaterialColor.GRASS;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, state.getValue(TYPE) == SlabType.DOUBLE ? 2 : 1));
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(ColorHandlerEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D);
		}, GrassslabsModBlocks.GRASS_SLAB);
	}

	@OnlyIn(Dist.CLIENT)
	public static void itemColorLoad(ColorHandlerEvent.Item event) {
		event.getItemColors().register((stack, index) -> {
			return GrassColor.get(0.5D, 1.0D);
		}, GrassslabsModBlocks.GRASS_SLAB);
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(GrassslabsModBlocks.GRASS_SLAB, renderType -> renderType == RenderType.cutoutMipped());
	}
}
