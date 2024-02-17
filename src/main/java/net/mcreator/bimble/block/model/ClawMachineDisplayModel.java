package net.mcreator.bimble.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.bimble.block.display.ClawMachineDisplayItem;

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
