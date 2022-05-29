
package com.kuraion.grassslabs.init;

import com.kuraion.grassslabs.GrassslabsMod;
import com.kuraion.grassslabs.block.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrassslabsModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GrassslabsMod.MODID);

	public static final RegistryObject<GrassSlabBlock> GRASS_SLAB = BLOCKS.register("grass_slab", GrassSlabBlock::new);
	public static final RegistryObject<GrassStairsBlock> GRASS_STAIRS = BLOCKS.register("grass_stairs", GrassStairsBlock::new);
	public static final RegistryObject<GrassCarpetBlock> GRASS_CARPET = BLOCKS.register("grass_carpet", GrassCarpetBlock::new);
	public static final RegistryObject<DirtSlabBlock> DIRT_SLAB = BLOCKS.register("dirt_slab", DirtSlabBlock::new);
	public static final RegistryObject<DirtStairsBlock> DIRT_STAIRS = BLOCKS.register("dirt_stairs", DirtStairsBlock::new);
	public static final RegistryObject<DirtCarpetBlock> DIRT_CARPET = BLOCKS.register("dirt_carpet", DirtCarpetBlock::new);
	public static final RegistryObject<DirtPathSlabBlock> DIRT_PATH_SLAB = BLOCKS.register("dirt_path_slab", DirtPathSlabBlock::new);
	public static final RegistryObject<DirtPathStairsBlock> DIRT_PATH_STAIRS = BLOCKS.register("dirt_path_stairs", DirtPathStairsBlock::new);
	public static final RegistryObject<DirtPathCarpetBlock> DIRT_PATH_CARPET = BLOCKS.register("dirt_path_carpet", DirtPathCarpetBlock::new);
	public static final RegistryObject<MyceliumSlabBlock> MYCELIUM_SLAB = BLOCKS.register("mycelium_slab", MyceliumSlabBlock::new);
	public static final RegistryObject<MyceliumStairsBlock> MYCELIUM_STAIRS = BLOCKS.register("mycelium_stairs", MyceliumStairsBlock::new);
	public static final RegistryObject<MyceliumCarpetBlock> MYCELIUM_CARPET = BLOCKS.register("mycelium_carpet", MyceliumCarpetBlock::new);

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
