package net.mcreator.bimble.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.bimble.entity.SusuwatariEntity;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

public class SusuwatariOnEntityTickUpdateProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		double slotnumber = 0;
		if (entity.getPersistentData().getBoolean("HasCopiedData") == true) {
			if (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
					return _retval.get();
				}
			}.getAmount(world, BlockPos.containing(entity.getPersistentData().getDouble("FurnaceX"), entity.getPersistentData().getDouble("FurnaceY"), entity.getPersistentData().getDouble("FurnaceZ")), 1) < 64) {
				if (entity.getPersistentData().getBoolean("HasCoal") == false) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("ChestX")), (entity.getPersistentData().getDouble("ChestY")), (entity.getPersistentData().getDouble("ChestZ")), 1);
					if ((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("ChestX"), entity.getPersistentData().getDouble("ChestY"), entity.getPersistentData().getDouble("ChestZ")))).getBlock() == Blocks.CHEST) {
						for (int index0 = 0; index0 < 27; index0++) {
							if (!((new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, BlockPos.containing(x, y, z), (int) slotnumber)).getItem() == Items.COAL)) {
								slotnumber = slotnumber + 1;
							} else if ((new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, BlockPos.containing(x, y, z), (int) slotnumber)).getItem() == Items.COAL) {
								entity.getPersistentData().putBoolean("HasCoal", true);
								{
									BlockEntity _ent = world.getBlockEntity(BlockPos.containing(entity.getPersistentData().getDouble("ChestX"), entity.getPersistentData().getDouble("ChestY"), entity.getPersistentData().getDouble("ChestZ")));
									if (_ent != null) {
										final int _slotid = (int) slotnumber;
										final int _amount = 1;
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
											if (capability instanceof IItemHandlerModifiable) {
												ItemStack _stk = capability.getStackInSlot(_slotid).copy();
												_stk.shrink(_amount);
												((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
											}
										});
									}
								}
								break;
							}
						}
					} else {
						entity.getPersistentData().putBoolean("HasCopiedData", false);
					}
				} else if (entity.getPersistentData().getBoolean("HasCoal") == true) {
					if (entity instanceof SusuwatariEntity) {
						((SusuwatariEntity) entity).setAnimation("RunwithCoal");
					}
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("FurnaceX")), (entity.getPersistentData().getDouble("FurnaceY")), (entity.getPersistentData().getDouble("FurnaceZ")), 1);
					if (entity.getY() == entity.getPersistentData().getDouble("FurnaceY") + 1) {
						if ((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("FurnaceX"), entity.getPersistentData().getDouble("FurnaceY"), entity.getPersistentData().getDouble("FurnaceZ"))))
								.getBlock() == Blocks.FURNACE) {
							if ((new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == Items.COAL || (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == Blocks.AIR.asItem()) {
								if (new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = world.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
										return _retval.get();
									}
								}.getAmount(world, BlockPos.containing(x, y, z), 1) >= 0) {
									entity.getPersistentData().putBoolean("HasCoal", false);
									{
										BlockEntity _ent = world
												.getBlockEntity(BlockPos.containing(entity.getPersistentData().getDouble("FurnaceX"), entity.getPersistentData().getDouble("FurnaceY"), entity.getPersistentData().getDouble("FurnaceZ")));
										if (_ent != null) {
											final int _slotid = 1;
											final ItemStack _setstack = new ItemStack(Items.COAL);
											_setstack.setCount((int) (new Object() {
												public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
													AtomicInteger _retval = new AtomicInteger(0);
													BlockEntity _ent = world.getBlockEntity(pos);
													if (_ent != null)
														_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
													return _retval.get();
												}
											}.getAmount(world, BlockPos.containing(entity.getPersistentData().getDouble("FurnaceX"), entity.getPersistentData().getDouble("FurnaceY"), entity.getPersistentData().getDouble("FurnaceZ")), 1) + 1));
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable)
													((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
											});
										}
									}
								} else {
									entity.getPersistentData().putBoolean("HasCoal", false);
									{
										BlockEntity _ent = world
												.getBlockEntity(BlockPos.containing(entity.getPersistentData().getDouble("FurnaceX"), entity.getPersistentData().getDouble("FurnaceY"), entity.getPersistentData().getDouble("FurnaceZ")));
										if (_ent != null) {
											final int _slotid = 1;
											final ItemStack _setstack = new ItemStack(Items.COAL);
											_setstack.setCount(1);
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable)
													((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
											});
										}
									}
								}
							}
						} else {
							entity.getPersistentData().putBoolean("HasCopiedData", false);
						}
					}
				}
			}
		}
		if (entity.isInWater() && entity instanceof SusuwatariEntity) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 20, 0.5, 0.5, 0.5, 0.1);
			if (!entity.level().isClientSide())
				entity.discard();
		}
		return false;
	}
}
