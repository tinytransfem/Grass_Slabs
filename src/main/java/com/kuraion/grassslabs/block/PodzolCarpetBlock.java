
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

public class PodzolCarpetBlock extends CarpetBlock {
	public PodzolCarpetBlock() {
		super(Properties.of(Material.GRASS).sound(SoundType.GRASS).strength(0.5f, 0.6f).lightLevel(s -> 0));
	}

	@Override
	public MaterialColor defaultMaterialColor() { return MaterialColor.GRASS; }

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
