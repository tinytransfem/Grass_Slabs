
package com.kuraion.grassslabs.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrassslabsModItems {
	@SubscribeEvent
	public static void onRegisterItems(Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		GrassslabsModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
			Properties properties = (new Item.Properties()).tab(CreativeModeTab.TAB_BUILDING_BLOCKS);
			BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
	}
}
