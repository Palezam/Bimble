package net.mcreator.bimble.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.bimble.entity.SusuwatariEntity;

public class SusuwatariModel extends GeoModel<SusuwatariEntity> {
	@Override
	public ResourceLocation getAnimationResource(SusuwatariEntity entity) {
		return new ResourceLocation("bimble", "animations/susuwatari.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SusuwatariEntity entity) {
		return new ResourceLocation("bimble", "geo/susuwatari.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SusuwatariEntity entity) {
		return new ResourceLocation("bimble", "textures/entities/" + entity.getTexture() + ".png");
	}

}
