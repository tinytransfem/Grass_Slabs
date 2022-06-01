
package com.kuraion.grassslabs.block;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.BiomeColors;

import java.util.List;
import java.util.Collections;

import com.kuraion.grassslabs.init.GrassslabsModBlocks;

public class GrassStairsBlock extends StairBlock {
    public GrassStairsBlock() {
        super(() -> (GrassslabsModBlocks.GRASS_SLAB.get()).defaultBlockState(), Properties.of(Material.DIRT).sound(SoundType.GRAVEL).strength(0.5f, 0.5f).lightLevel(s -> 0).dynamicShape());
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }

    @OnlyIn(Dist.CLIENT)
    public static void blockColorLoad(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D);
        }, GrassslabsModBlocks.GRASS_STAIRS.get());
    }

    @OnlyIn(Dist.CLIENT)
    public static void itemColorLoad(ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, index) -> {
            return GrassColor.get(0.5D, 1.0D);
        }, GrassslabsModBlocks.GRASS_STAIRS.get());
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(GrassslabsModBlocks.GRASS_STAIRS.get(), renderType -> renderType == RenderType.cutoutMipped());
    }
}
