package net.mcreator.bimble.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.bimble.init.BimbleModBlockEntities;
import net.mcreator.bimble.block.renderer.RecyclerTileRenderer;
import net.mcreator.bimble.block.renderer.ClawMachineTileRenderer;
import net.mcreator.bimble.BimbleMod;

@Mod.EventBusSubscriber(modid = BimbleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(BimbleModBlockEntities.RECYCLER.get(), context -> new RecyclerTileRenderer());
		event.registerBlockEntityRenderer(BimbleModBlockEntities.CLAW_MACHINE.get(), context -> new ClawMachineTileRenderer());
	}
}
