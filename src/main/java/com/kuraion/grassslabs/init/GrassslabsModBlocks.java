
package com.kuraion.grassslabs.init;

import com.kuraion.grassslabs.block.*;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrassslabsModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block GRASS_SLAB = register(new GrassSlabBlock());
	public static final Block GRASS_STAIRS = register(new GrassStairsBlock());
	public static final Block GRASS_CARPET = register(new GrassCarpetBlock());
	public static final Block DIRT_SLAB = register(new DirtSlabBlock());
	public static final Block DIRT_STAIRS = register(new DirtStairsBlock());
	public static final Block DIRT_CARPET = register(new DirtCarpetBlock());
	public static final Block DIRT_PATH_SLAB = register(new DirtPathSlabBlock());
	public static final Block DIRT_PATH_STAIRS = register(new DirtPathStairsBlock());
	public static final Block DIRT_PATH_CARPET = register(new DirtPathCarpetBlock());
	public static final Block MYCELIUM_SLAB = register(new MyceliumSlabBlock());
	public static final Block MYCELIUM_STAIRS = register(new MyceliumStairsBlock());
	public static final Block MYCELIUM_CARPET = register(new MyceliumCarpetBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			GrassSlabBlock.registerRenderLayer();
			GrassStairsBlock.registerRenderLayer();
			DirtPathSlabBlock.registerRenderLayer();
		}

		@SubscribeEvent
		public static void blockColorLoad(ColorHandlerEvent.Block event) {
			GrassSlabBlock.blockColorLoad(event);
			GrassStairsBlock.blockColorLoad(event);
			GrassCarpetBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(ColorHandlerEvent.Item event) {
			GrassSlabBlock.itemColorLoad(event);
			GrassStairsBlock.itemColorLoad(event);
			GrassCarpetBlock.itemColorLoad(event);
		}
	}
}
