
package com.kuraion.grassslabs.block;

import com.kuraion.grassslabs.init.GrassslabsModBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class GrassStairsBlock extends StairBlock {
    private final Supplier<BlockState> flattenedBlock;

    public GrassStairsBlock(RegistryObject<DirtPathStairsBlock> flattenedBlock) {
        super(() -> (GrassslabsModBlocks.GRASS_SLAB.get()).defaultBlockState(), Properties.copy(Blocks.GRASS_BLOCK).sound(SoundType.GRAVEL).strength(0.5f, 0.5f).lightLevel(s -> 0).dynamicShape());
        this.flattenedBlock = flattenedBlock == null ? null : () -> flattenedBlock.get().defaultBlockState();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }

    @OnlyIn(Dist.CLIENT)
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D);
        }, GrassslabsModBlocks.GRASS_STAIRS.get());
    }

    @OnlyIn(Dist.CLIENT)
    public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, index) -> {
            return GrassColor.get(0.5D, 1.0D);
        }, GrassslabsModBlocks.GRASS_STAIRS.get());
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(GrassslabsModBlocks.GRASS_STAIRS.get(), renderType -> renderType == RenderType.cutoutMipped());
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        
        if (flattenedBlock == null)
            return super.getToolModifiedState(state, context, toolAction, simulate);

        return ToolActions.SHOVEL_FLATTEN.equals(toolAction) ? flattenedBlock.get() : null;
    }
}
