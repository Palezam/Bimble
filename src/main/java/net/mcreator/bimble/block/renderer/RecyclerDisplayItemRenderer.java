package net.mcreator.bimble.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.bimble.block.model.RecyclerDisplayModel;
import net.mcreator.bimble.block.display.RecyclerDisplayItem;

public class RecyclerDisplayItemRenderer extends GeoItemRenderer<RecyclerDisplayItem> {
	public RecyclerDisplayItemRenderer() {
		super(new RecyclerDisplayModel());
	}

	@Override
	public RenderType getRenderType(RecyclerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
