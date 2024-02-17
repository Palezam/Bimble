package net.mcreator.bimble.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.bimble.block.model.ClawMachineBlockModel;
import net.mcreator.bimble.block.entity.ClawMachineTileEntity;

public class ClawMachineTileRenderer extends GeoBlockRenderer<ClawMachineTileEntity> {
	public ClawMachineTileRenderer() {
		super(new ClawMachineBlockModel());
	}

	@Override
	public RenderType getRenderType(ClawMachineTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
