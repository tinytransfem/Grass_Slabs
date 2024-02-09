
package com.kuraion.grassslabs.block;

import com.kuraion.grassslabs.init.GrassslabsModBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;

import java.util.Collections;
import java.util.List;

public class DirtStairsBlock extends StairBlock {
    public DirtStairsBlock() {
        super(() -> (GrassslabsModBlocks.DIRT_SLAB.get()).defaultBlockState(), Properties.copy(Blocks.DIRT).sound(SoundType.GRAVEL).strength(0.5f, 0.5f).lightLevel(s -> 0).dynamicShape());
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }
}
