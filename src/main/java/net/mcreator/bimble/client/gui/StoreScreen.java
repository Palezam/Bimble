package net.mcreator.bimble.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.bimble.world.inventory.StoreMenu;
import net.mcreator.bimble.network.StoreButtonMessage;
import net.mcreator.bimble.BimbleMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StoreScreen extends AbstractContainerScreen<StoreMenu> {
	private final static HashMap<String, Object> guistate = StoreMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_buy;
	Button button_buy1;

	public StoreScreen(StoreMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("bimble:textures/screens/store.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.bimble.store.label_apple"), 6, 11, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.bimble.store.label_1x_double_barrel"), 6, 45, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_buy = Button.builder(Component.translatable("gui.bimble.store.button_buy"), e -> {
			if (true) {
				BimbleMod.PACKET_HANDLER.sendToServer(new StoreButtonMessage(0, x, y, z));
				StoreButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 23, 40, 20).build();
		guistate.put("button:button_buy", button_buy);
		this.addRenderableWidget(button_buy);
		button_buy1 = Button.builder(Component.translatable("gui.bimble.store.button_buy1"), e -> {
			if (true) {
				BimbleMod.PACKET_HANDLER.sendToServer(new StoreButtonMessage(1, x, y, z));
				StoreButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 56, 40, 20).build();
		guistate.put("button:button_buy1", button_buy1);
		this.addRenderableWidget(button_buy1);
	}
}
