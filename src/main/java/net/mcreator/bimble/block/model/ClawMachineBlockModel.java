package net.mcreator.bimble.block.model;

public class ClawMachineBlockModel extends GeoModel<ClawMachineTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ClawMachineTileEntity animatable) {
		return new ResourceLocation("bimble", "animations/clawmachine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ClawMachineTileEntity animatable) {
		return new ResourceLocation("bimble", "geo/clawmachine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ClawMachineTileEntity entity) {
		return new ResourceLocation("bimble", "textures/block/clawmachientexture2.png");
	}
}