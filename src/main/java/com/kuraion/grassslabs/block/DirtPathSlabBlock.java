
package com.kuraion.grassslabs.block;

import com.kuraion.grassslabs.init.GrassslabsModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class DirtPathSlabBlock extends SlabBlock {
	public DirtPathSlabBlock() {
		super(Properties.copy(Blocks.DIRT).sound(SoundType.GRASS).strength(0.65f, 0.65f).lightLevel(s -> 0));
	}

	protected static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
	protected static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 15.0D, 16.0D);

	@Override
	public VoxelShape getShape(@NotNull BlockState p_56390_, BlockGetter p_56391_, BlockPos p_56392_, CollisionContext p_56393_) {
		SlabType slabtype = p_56390_.getValue(TYPE);
		switch(slabtype) {
			case DOUBLE:
				return Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
			case TOP:
				return TOP_AABB;
			default:
				return BOTTOM_AABB;
		}
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(GrassslabsModBlocks.DIRT_PATH_SLAB.get(), renderType -> renderType == RenderType.cutout());
	}
}
