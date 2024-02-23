package net.mcreator.bimble.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Comparator;

public class RoombaOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity targetentity = null;
		ItemStack targeteditem = ItemStack.EMPTY;
		double slot = 0;
		double amount = 0;
		double targetitemamount = 0;
		double slot2 = 0;
		if (((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof ItemEntity) {
			targetentity = (Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
			targeteditem = (targetentity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY);
			targetitemamount = targeteditem.getCount();
			slot = 0;
			for (int index0 = 0; index0 < 9; index0++) {
				amount = (new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) slot, entity)).getCount();
				if ((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) slot, entity)).getItem() == targeteditem.getItem() && amount + targetitemamount <= 64) {
					if (amount + targetitemamount >= 64) {
						if (!targetentity.level().isClientSide())
							targetentity.discard();
						{
							final int _slotid = (int) slot;
							final ItemStack _setstack = targeteditem;
							_setstack.setCount(64);
							entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable _modHandler)
									_modHandler.setStackInSlot(_slotid, _setstack);
							});
						}
						slot2 = slot;
						for (int index1 = 0; index1 < 9; index1++) {
							if ((new Object() {
								public ItemStack getItemStack(int sltid, Entity entity) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) slot2, entity)).getItem() == ItemStack.EMPTY.getItem()) {
								{
									final int _slotid = (int) slot;
									final ItemStack _setstack = targeteditem;
									_setstack.setCount(targeteditem.getCount());
									entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable _modHandler)
											_modHandler.setStackInSlot(_slotid, _setstack);
									});
								}
							} else if (slot2 <= 9) {
								break;
							} else {
								slot = slot2 + 1;
							}
						}
						break;
					} else {
						if (!targetentity.level().isClientSide())
							targetentity.discard();
						{
							final int _slotid = (int) slot;
							final ItemStack _setstack = targeteditem;
							_setstack.setCount((int) (amount + targeteditem.getCount()));
							entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable _modHandler)
									_modHandler.setStackInSlot(_slotid, _setstack);
							});
						}
						break;
					}
				} else if ((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) slot, entity)).getItem() == ItemStack.EMPTY.getItem()) {
					if (!targetentity.level().isClientSide())
						targetentity.discard();
					{
						final int _slotid = (int) slot;
						final ItemStack _setstack = targeteditem;
						_setstack.setCount(targeteditem.getCount());
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable _modHandler)
								_modHandler.setStackInSlot(_slotid, _setstack);
						});
					}
					break;
				} else {
					slot = slot + 1;
				}
			}
		}
	}
}
