package net.mcreator.bimble.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.bimble.entity.RoombaEntity;

public class RoombaModel extends GeoModel<RoombaEntity> {
	@Override
	public ResourceLocation getAnimationResource(RoombaEntity entity) {
		return new ResourceLocation("bimble", "animations/roomba.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RoombaEntity entity) {
		return new ResourceLocation("bimble", "geo/roomba.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RoombaEntity entity) {
		return new ResourceLocation("bimble", "textures/entities/" + entity.getTexture() + ".png");
	}

}
