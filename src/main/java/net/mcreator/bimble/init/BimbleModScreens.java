
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bimble.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.bimble.client.gui.StoreScreen;
import net.mcreator.bimble.client.gui.RoombaGuiScreen;
import net.mcreator.bimble.client.gui.ClawMachineGuiScreen;
import net.mcreator.bimble.client.gui.CatalogScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BimbleModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(BimbleModMenus.CATALOG.get(), CatalogScreen::new);
			MenuScreens.register(BimbleModMenus.STORE.get(), StoreScreen::new);
			MenuScreens.register(BimbleModMenus.CLAW_MACHINE_GUI.get(), ClawMachineGuiScreen::new);
			MenuScreens.register(BimbleModMenus.ROOMBA_GUI.get(), RoombaGuiScreen::new);
		});
	}
}
