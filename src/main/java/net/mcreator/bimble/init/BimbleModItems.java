
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bimble.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.bimble.item.StarCandyItem;
import net.mcreator.bimble.item.ShotgunShellItem;
import net.mcreator.bimble.item.DoubleBarrelItem;
import net.mcreator.bimble.item.DoubleBarrelBulletsItem;
import net.mcreator.bimble.item.CatalogConsoleItem;
import net.mcreator.bimble.item.BowlOfSootItem;
import net.mcreator.bimble.block.display.RecyclerDisplayItem;
import net.mcreator.bimble.block.display.ClawMachineDisplayItem;
import net.mcreator.bimble.BimbleMod;

public class BimbleModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BimbleMod.MODID);
	public static final RegistryObject<Item> CATALOG_CONSOLE = REGISTRY.register("catalog_console", () -> new CatalogConsoleItem());
	public static final RegistryObject<Item> DRONE_SPAWN_EGG = REGISTRY.register("drone_spawn_egg", () -> new ForgeSpawnEggItem(BimbleModEntities.DRONE, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> UME_EGG = block(BimbleModBlocks.UME_EGG);
	public static final RegistryObject<Item> STAR_CANDY = REGISTRY.register("star_candy", () -> new StarCandyItem());
	public static final RegistryObject<Item> SHOTGUN_SHELL = REGISTRY.register("shotgun_shell", () -> new ShotgunShellItem());
	public static final RegistryObject<Item> DOUBLE_BARREL = REGISTRY.register("double_barrel", () -> new DoubleBarrelItem());
	public static final RegistryObject<Item> DOUBLE_BARREL_BULLETS = REGISTRY.register("double_barrel_bullets", () -> new DoubleBarrelBulletsItem());
	public static final RegistryObject<Item> SUSUWATARI_SPAWN_EGG = REGISTRY.register("susuwatari_spawn_egg", () -> new ForgeSpawnEggItem(BimbleModEntities.SUSUWATARI, -10066330, -1, new Item.Properties()));
	public static final RegistryObject<Item> BOWL_OF_SOOT = REGISTRY.register("bowl_of_soot", () -> new BowlOfSootItem());
	public static final RegistryObject<Item> RECYCLER = REGISTRY.register(BimbleModBlocks.RECYCLER.getId().getPath(), () -> new RecyclerDisplayItem(BimbleModBlocks.RECYCLER.get(), new Item.Properties()));
	public static final RegistryObject<Item> CLAW_MACHINE = REGISTRY.register(BimbleModBlocks.CLAW_MACHINE.getId().getPath(), () -> new ClawMachineDisplayItem(BimbleModBlocks.CLAW_MACHINE.get(), new Item.Properties()));

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
