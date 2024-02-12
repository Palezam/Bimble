package net.mcreator.bimble.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.bimble.block.entity.RecyclerTileEntity;

public class RecyclerBlockModel extends GeoModel<RecyclerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(RecyclerTileEntity animatable) {
		return new ResourceLocation("bimble", "animations/recycler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RecyclerTileEntity animatable) {
		return new ResourceLocation("bimble", "geo/recycler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RecyclerTileEntity entity) {
		return new ResourceLocation("bimble", "textures/block/recycler.png");
	}
}
