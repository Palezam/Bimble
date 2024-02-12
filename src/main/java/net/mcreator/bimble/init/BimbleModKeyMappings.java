
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bimble.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.bimble.network.DoubleBarrelReloadMessage;
import net.mcreator.bimble.BimbleMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BimbleModKeyMappings {
	public static final KeyMapping DOUBLE_BARREL_RELOAD = new KeyMapping("key.bimble.double_barrel_reload", GLFW.GLFW_KEY_R, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BimbleMod.PACKET_HANDLER.sendToServer(new DoubleBarrelReloadMessage(0, 0));
				DoubleBarrelReloadMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(DOUBLE_BARREL_RELOAD);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				DOUBLE_BARREL_RELOAD.consumeClick();
			}
		}
	}
}
