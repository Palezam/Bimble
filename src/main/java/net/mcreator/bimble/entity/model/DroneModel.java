package net.mcreator.bimble.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.bimble.entity.DroneEntity;

public class DroneModel extends GeoModel<DroneEntity> {
	@Override
	public ResourceLocation getAnimationResource(DroneEntity entity) {
		return new ResourceLocation("bimble", "animations/drone.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DroneEntity entity) {
		return new ResourceLocation("bimble", "geo/drone.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DroneEntity entity) {
		return new ResourceLocation("bimble", "textures/entities/" + entity.getTexture() + ".png");
	}

}
