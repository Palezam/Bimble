package net.mcreator.bimble.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.bimble.block.display.RecyclerDisplayItem;

public class RecyclerDisplayModel extends GeoModel<RecyclerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(RecyclerDisplayItem animatable) {
		return new ResourceLocation("bimble", "animations/recycler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RecyclerDisplayItem animatable) {
		return new ResourceLocation("bimble", "geo/recycler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RecyclerDisplayItem entity) {
		return new ResourceLocation("bimble", "textures/block/recycler.png");
	}
}
