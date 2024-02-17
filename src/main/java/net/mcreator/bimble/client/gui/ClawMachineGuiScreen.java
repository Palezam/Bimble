package net.mcreator.bimble.client.gui;

public class ClawMachineGuiScreen extends AbstractContainerScreen<ClawMachineGuiMenu> {

	private final static HashMap<String, Object> guistate = ClawMachineGuiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	Button button_play_20_solari;

	public ClawMachineGuiScreen(ClawMachineGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("bimble:textures/screens/claw_machine_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);

		super.render(guiGraphics, mouseX, mouseY, partialTicks);

		this.renderTooltip(guiGraphics, mouseX, mouseY);

	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}

		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();

		button_play_20_solari = Button.builder(Component.translatable("gui.bimble.claw_machine_gui.button_play_20_solari"), e -> {
			if (true) {
				BimbleMod.PACKET_HANDLER.sendToServer(new ClawMachineGuiButtonMessage(0, x, y, z));
				ClawMachineGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -47, this.topPos + 73, 108, 20).build();

		guistate.put("button:button_play_20_solari", button_play_20_solari);
		this.addRenderableWidget(button_play_20_solari);

	}

}
