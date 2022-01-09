
package com.kuraion.grassslabs.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrassslabsModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item GRASS_SLAB = register(GrassslabsModBlocks.GRASS_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item GRASS_STAIRS = register(GrassslabsModBlocks.GRASS_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item GRASS_CARPET = register(GrassslabsModBlocks.GRASS_CARPET, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DIRT_SLAB = register(GrassslabsModBlocks.DIRT_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DIRT_STAIRS = register(GrassslabsModBlocks.DIRT_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DIRT_CARPET = register(GrassslabsModBlocks.DIRT_CARPET, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MYCELIUM_SLAB = register(GrassslabsModBlocks.MYCELIUM_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MYCELIUM_STAIRS = register(GrassslabsModBlocks.MYCELIUM_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MYCELIUM_CARPET = register(GrassslabsModBlocks.MYCELIUM_CARPET, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DIRT_PATH_SLAB = register(GrassslabsModBlocks.DIRT_PATH_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DIRT_PATH_STAIRS = register(GrassslabsModBlocks.DIRT_PATH_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DIRT_PATH_CARPET = register(GrassslabsModBlocks.DIRT_PATH_CARPET, CreativeModeTab.TAB_BUILDING_BLOCKS);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
