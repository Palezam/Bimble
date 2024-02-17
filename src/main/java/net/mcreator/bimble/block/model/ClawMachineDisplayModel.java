package net.mcreator.bimble.block.model;

public class ClawMachineDisplayModel extends GeoModel<ClawMachineDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ClawMachineDisplayItem animatable) {
		return new ResourceLocation("bimble", "animations/clawmachine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ClawMachineDisplayItem animatable) {
		return new ResourceLocation("bimble", "geo/clawmachine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ClawMachineDisplayItem entity) {
		return new ResourceLocation("bimble", "textures/block/clawmachientexture2.png");
	}
}