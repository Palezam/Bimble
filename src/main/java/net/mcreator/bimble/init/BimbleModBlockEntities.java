
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bimble.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.bimble.block.entity.UmeEggBlockEntity;
import net.mcreator.bimble.block.entity.RecyclerTileEntity;
import net.mcreator.bimble.block.entity.ClawMachineTileEntity;
import net.mcreator.bimble.BimbleMod;

public class BimbleModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BimbleMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> UME_EGG = register("ume_egg", BimbleModBlocks.UME_EGG, UmeEggBlockEntity::new);
	public static final RegistryObject<BlockEntityType<RecyclerTileEntity>> RECYCLER = REGISTRY.register("recycler", () -> BlockEntityType.Builder.of(RecyclerTileEntity::new, BimbleModBlocks.RECYCLER.get()).build(null));
	public static final RegistryObject<BlockEntityType<ClawMachineTileEntity>> CLAW_MACHINE = REGISTRY.register("claw_machine", () -> BlockEntityType.Builder.of(ClawMachineTileEntity::new, BimbleModBlocks.CLAW_MACHINE.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
