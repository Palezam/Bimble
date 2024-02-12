package net.mcreator.bimble.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.bimble.world.inventory.CatalogMenu;
import net.mcreator.bimble.procedures.WednesDayDisplayProcedure;
import net.mcreator.bimble.procedures.TuesdayDisplayProcedure;
import net.mcreator.bimble.procedures.ThursdayDisplayProcedure;
import net.mcreator.bimble.procedures.SundayDisplayProcedure;
import net.mcreator.bimble.procedures.SaturdayDisplayProcedure;
import net.mcreator.bimble.procedures.MondayDisplayProcedure;
import net.mcreator.bimble.procedures.FridayDisplayProcedure;
import net.mcreator.bimble.network.CatalogButtonMessage;
import net.mcreator.bimble.BimbleMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CatalogScreen extends AbstractContainerScreen<CatalogMenu> {
	private final static HashMap<String, Object> guistate = CatalogMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_shopnotselected;
	ImageButton imagebutton_convertnotselected;
	ImageButton imagebutton_infonotselected;

	public CatalogScreen(CatalogMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 127;
	}

	private static final ResourceLocation texture = new ResourceLocation("bimble:textures/screens/catalog.png");

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

		guiGraphics.blit(new ResourceLocation("bimble:textures/screens/hub.png"), this.leftPos + -61, this.topPos + -18, 0, 0, 300, 167, 300, 167);

		if (FridayDisplayProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("bimble:textures/screens/friday.png"), this.leftPos + 15, this.topPos + 24, 0, 0, 92, 12, 92, 12);
		}
		if (WednesDayDisplayProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("bimble:textures/screens/wednesday.png"), this.leftPos + 15, this.topPos + 24, 0, 0, 92, 12, 92, 12);
		}
		if (SundayDisplayProcedure.execute(world)) {
			guiGraphics.blit(new ResourceLocation("bimble:textures/screens/sunday.png"), this.leftPos + 15, this.topPos + 24, 0, 0, 92, 12, 92, 12);
		}
		if (TuesdayDisplayProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("bimble:textures/screens/tuesday.png"), this.leftPos + 15, this.topPos + 24, 0, 0, 92, 12, 92, 12);
		}
		if (MondayDisplayProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("bimble:textures/screens/monday.png"), this.leftPos + 15, this.topPos + 24, 0, 0, 92, 12, 92, 12);
		}
		if (ThursdayDisplayProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("bimble:textures/screens/thursday.png"), this.leftPos + 15, this.topPos + 24, 0, 0, 92, 12, 92, 12);
		}
		if (SaturdayDisplayProcedure.execute()) {
			guiGraphics.blit(new ResourceLocation("bimble:textures/screens/saturday.png"), this.leftPos + 15, this.topPos + 24, 0, 0, 92, 12, 92, 12);
		}
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
		imagebutton_shopnotselected = new ImageButton(this.leftPos + -38, this.topPos + 60, 48, 10, 0, 0, 10, new ResourceLocation("bimble:textures/screens/atlas/imagebutton_shopnotselected.png"), 48, 20, e -> {
			if (true) {
				BimbleMod.PACKET_HANDLER.sendToServer(new CatalogButtonMessage(0, x, y, z));
				CatalogButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_shopnotselected", imagebutton_shopnotselected);
		this.addRenderableWidget(imagebutton_shopnotselected);
		imagebutton_convertnotselected = new ImageButton(this.leftPos + -38, this.topPos + 80, 70, 10, 0, 0, 10, new ResourceLocation("bimble:textures/screens/atlas/imagebutton_convertnotselected.png"), 70, 20, e -> {
		});
		guistate.put("button:imagebutton_convertnotselected", imagebutton_convertnotselected);
		this.addRenderableWidget(imagebutton_convertnotselected);
		imagebutton_infonotselected = new ImageButton(this.leftPos + -38, this.topPos + 100, 46, 10, 0, 0, 10, new ResourceLocation("bimble:textures/screens/atlas/imagebutton_infonotselected.png"), 46, 20, e -> {
		});
		guistate.put("button:imagebutton_infonotselected", imagebutton_infonotselected);
		this.addRenderableWidget(imagebutton_infonotselected);
	}
}
