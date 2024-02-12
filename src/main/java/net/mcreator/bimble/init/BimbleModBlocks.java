
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bimble.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.bimble.block.UmeEggBlock;
import net.mcreator.bimble.block.RecyclerBlock;
import net.mcreator.bimble.BimbleMod;

public class BimbleModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BimbleMod.MODID);
	public static final RegistryObject<Block> UME_EGG = REGISTRY.register("ume_egg", () -> new UmeEggBlock());
	public static final RegistryObject<Block> RECYCLER = REGISTRY.register("recycler", () -> new RecyclerBlock());
}
