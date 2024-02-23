
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bimble.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.bimble.client.renderer.SusuwatariRenderer;
import net.mcreator.bimble.client.renderer.RoombaRenderer;
import net.mcreator.bimble.client.renderer.DroneRenderer;
import net.mcreator.bimble.client.renderer.CoconutterRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BimbleModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BimbleModEntities.DRONE.get(), DroneRenderer::new);
		event.registerEntityRenderer(BimbleModEntities.DOUBLE_BARREL_BULLETS.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(BimbleModEntities.SUSUWATARI.get(), SusuwatariRenderer::new);
		event.registerEntityRenderer(BimbleModEntities.COCONUTTER.get(), CoconutterRenderer::new);
		event.registerEntityRenderer(BimbleModEntities.COCONUT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(BimbleModEntities.ROOMBA.get(), RoombaRenderer::new);
	}
}
