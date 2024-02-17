package net.mcreator.bimble.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.bimble.entity.CoconutterEntity;

public class CoconutterModel extends GeoModel<CoconutterEntity> {
	@Override
	public ResourceLocation getAnimationResource(CoconutterEntity entity) {
		return new ResourceLocation("bimble", "animations/coconutter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CoconutterEntity entity) {
		return new ResourceLocation("bimble", "geo/coconutter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CoconutterEntity entity) {
		return new ResourceLocation("bimble", "textures/entities/" + entity.getTexture() + ".png");
	}

}
