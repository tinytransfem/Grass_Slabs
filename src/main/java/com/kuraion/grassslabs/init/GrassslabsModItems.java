
package com.kuraion.grassslabs.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrassslabsModItems {
	@SubscribeEvent
	public static void onRegisterItems(RegisterEvent event) {
		if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)){
			GrassslabsModBlocks.BLOCKS.getEntries().forEach( (blockRegistryObject) -> {
				Block block = blockRegistryObject.get();
				Item.Properties properties = new Item.Properties();
				Supplier<Item> blockItemFactory = () -> new BlockItem(block, properties);
				event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), blockItemFactory);
			});
		}
	}

	@SubscribeEvent
	public static void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			GrassslabsModBlocks.BLOCKS.getEntries().forEach( (blockRegistryObject) -> {
				Block block = blockRegistryObject.get();
				event.accept(block);
			});
		}
	}
}
