
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bimble.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.bimble.world.inventory.StoreMenu;
import net.mcreator.bimble.world.inventory.ClawMachineGuiMenu;
import net.mcreator.bimble.world.inventory.CatalogMenu;
import net.mcreator.bimble.BimbleMod;

public class BimbleModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BimbleMod.MODID);
	public static final RegistryObject<MenuType<CatalogMenu>> CATALOG = REGISTRY.register("catalog", () -> IForgeMenuType.create(CatalogMenu::new));
	public static final RegistryObject<MenuType<StoreMenu>> STORE = REGISTRY.register("store", () -> IForgeMenuType.create(StoreMenu::new));
	public static final RegistryObject<MenuType<ClawMachineGuiMenu>> CLAW_MACHINE_GUI = REGISTRY.register("claw_machine_gui", () -> IForgeMenuType.create(ClawMachineGuiMenu::new));
}
