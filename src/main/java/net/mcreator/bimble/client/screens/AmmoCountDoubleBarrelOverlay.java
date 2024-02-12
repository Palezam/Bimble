
package net.mcreator.bimble.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.bimble.procedures.DBAmmoCountProcedure;
import net.mcreator.bimble.procedures.AmmoCount2Procedure;
import net.mcreator.bimble.procedures.AmmoCount1Procedure;
import net.mcreator.bimble.procedures.AmmoCount0Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class AmmoCountDoubleBarrelOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (DBAmmoCountProcedure.execute(entity)) {
			if (AmmoCount1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("bimble:textures/screens/ammocount1.png"), posX + 89, posY + 93, 0, 0, 32, 32, 32, 32);
			}
			if (AmmoCount0Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("bimble:textures/screens/ammocount0.png"), posX + 89, posY + 93, 0, 0, 32, 32, 32, 32);
			}
			if (AmmoCount2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("bimble:textures/screens/ammocount2.png"), posX + 89, posY + 93, 0, 0, 32, 32, 32, 32);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
