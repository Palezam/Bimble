package net.mcreator.bimble.block.renderer;

public class ClawMachineTileRenderer extends GeoBlockRenderer<ClawMachineTileEntity> {
	public ClawMachineTileRenderer() {
		super(new ClawMachineBlockModel());
	}

	@Override
	public RenderType getRenderType(ClawMachineTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}