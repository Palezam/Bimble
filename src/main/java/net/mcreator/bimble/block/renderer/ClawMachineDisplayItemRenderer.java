package net.mcreator.bimble.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.bimble.block.model.ClawMachineDisplayModel;
import net.mcreator.bimble.block.display.ClawMachineDisplayItem;

public class ClawMachineDisplayItemRenderer extends GeoItemRenderer<ClawMachineDisplayItem> {
	public ClawMachineDisplayItemRenderer() {
		super(new ClawMachineDisplayModel());
	}

	@Override
	public RenderType getRenderType(ClawMachineDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
