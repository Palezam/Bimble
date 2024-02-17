package net.mcreator.bimble.block.renderer;

public class ClawMachineDisplayItemRenderer extends GeoItemRenderer<ClawMachineDisplayItem> {
	public ClawMachineDisplayItemRenderer() {
		super(new ClawMachineDisplayModel());
	}

	@Override
	public RenderType getRenderType(ClawMachineDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}