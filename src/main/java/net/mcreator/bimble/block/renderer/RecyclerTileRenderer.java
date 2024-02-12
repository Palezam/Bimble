package net.mcreator.bimble.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.bimble.block.model.RecyclerBlockModel;
import net.mcreator.bimble.block.entity.RecyclerTileEntity;

public class RecyclerTileRenderer extends GeoBlockRenderer<RecyclerTileEntity> {
	public RecyclerTileRenderer() {
		super(new RecyclerBlockModel());
	}

	@Override
	public RenderType getRenderType(RecyclerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
