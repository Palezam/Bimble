package net.mcreator.bimble.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.bimble.network.BimbleModVariables;
import net.mcreator.bimble.item.DoubleBarrelItem;
import net.mcreator.bimble.init.BimbleModItems;
import net.mcreator.bimble.BimbleMod;

public class DoubleBarrelReloadOnKeyPressedProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == BimbleModItems.DOUBLE_BARREL.get()
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(BimbleModItems.SHOTGUN_SHELL.get())) : false)
				&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("ammo") == 2)
				&& !(entity instanceof Player _player ? _player.getCooldowns().isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) : false)) {
			{
				ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
				entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DoubleBarrelStore = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("ammo") == 0) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).DoubleBarrelStore).getItem(), 80);
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
						world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
				}
				if (((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).DoubleBarrelStore).getItem() instanceof DoubleBarrelItem)
					((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).DoubleBarrelStore).getOrCreateTag().putString("geckoAnim", "reload");
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("ammo") == 1) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).DoubleBarrelStore).getItem(), 75);
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
						world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
				}
				if (((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).DoubleBarrelStore).getItem() instanceof DoubleBarrelItem)
					((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).DoubleBarrelStore).getOrCreateTag().putString("geckoAnim", "reload1bullet");
			}
			BimbleMod.queueServerWork(48, () -> {
				if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(BimbleModItems.SHOTGUN_SHELL.get())) : false)
						&& !(((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).DoubleBarrelStore).getOrCreateTag().getDouble("ammo") == 1)) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(BimbleModItems.SHOTGUN_SHELL.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == BimbleModItems.DOUBLE_BARREL.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("ammo", 1);
					} else {
						((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).DoubleBarrelStore).getOrCreateTag().putDouble("ammo", 1);
					}
				}
			});
			BimbleMod.queueServerWork(55, () -> {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(BimbleModItems.SHOTGUN_SHELL.get())) : false) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(BimbleModItems.SHOTGUN_SHELL.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == BimbleModItems.DOUBLE_BARREL.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("ammo", 2);
					} else {
						((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).DoubleBarrelStore).getOrCreateTag().putDouble("ammo", 2);
					}
				}
			});
		}
		return false;
	}
}
