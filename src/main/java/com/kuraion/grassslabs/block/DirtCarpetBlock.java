
package com.kuraion.grassslabs.block;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.Collections;
import java.util.List;

public class DirtCarpetBlock extends CarpetBlock {
	public DirtCarpetBlock() {
		super(Properties.of(Material.DIRT).sound(SoundType.GRAVEL).strength(0.1f, 0.1f).lightLevel(s -> 0));
	}

	@Override
	public MaterialColor defaultMaterialColor() {
		return MaterialColor.DIRT;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
