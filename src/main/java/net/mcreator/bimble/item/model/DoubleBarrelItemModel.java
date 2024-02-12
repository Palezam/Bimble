package net.mcreator.bimble.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.bimble.item.DoubleBarrelItem;

public class DoubleBarrelItemModel extends GeoModel<DoubleBarrelItem> {
	@Override
	public ResourceLocation getAnimationResource(DoubleBarrelItem animatable) {
		return new ResourceLocation("bimble", "animations/doublebarrel.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DoubleBarrelItem animatable) {
		return new ResourceLocation("bimble", "geo/doublebarrel.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DoubleBarrelItem animatable) {
		return new ResourceLocation("bimble", "textures/item/texture.png");
	}
}
