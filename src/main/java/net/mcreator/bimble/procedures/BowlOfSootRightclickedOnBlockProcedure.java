package net.mcreator.bimble.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.bimble.init.BimbleModEntities;

public class BowlOfSootRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FURNACE) {
				entity.getPersistentData().putBoolean("CopiedFurnaceData", true);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Furnace position set!"), false);
				entity.getPersistentData().putDouble("FurnaceX", x);
				entity.getPersistentData().putDouble("FurnaceY", y);
				entity.getPersistentData().putDouble("FurnaceZ", z);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CHEST) {
				entity.getPersistentData().putBoolean("CopiedChestData", true);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Chest position set!"), false);
				entity.getPersistentData().putDouble("ChestX", x);
				entity.getPersistentData().putDouble("ChestY", y);
				entity.getPersistentData().putDouble("ChestZ", z);
			}
		}
		if (!entity.isShiftKeyDown()) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.BOWL)) : false) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.BOWL);
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR);
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.BOWL);
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if (entity.getPersistentData().getBoolean("CopiedFurnaceData") == true && entity.getPersistentData().getBoolean("CopiedChestData") == true) {
				if (world instanceof ServerLevel _level) {
					Entity _entityToSpawn = BimbleModEntities.SUSUWATARI.get().create(_level);
					_entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360.0F, 0.0F);
					if (_entityToSpawn instanceof Mob _mobToSpawn) {
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(_entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					}
					(_entityToSpawn).getPersistentData().putBoolean("HasCopiedData", true);
					(_entityToSpawn).getPersistentData().putDouble("FurnaceX", (entity.getPersistentData().getDouble("FurnaceX")));
					(_entityToSpawn).getPersistentData().putDouble("FurnaceY", (entity.getPersistentData().getDouble("FurnaceY")));
					(_entityToSpawn).getPersistentData().putDouble("FurnaceZ", (entity.getPersistentData().getDouble("FurnaceZ")));
					(_entityToSpawn).getPersistentData().putDouble("ChestX", (entity.getPersistentData().getDouble("ChestX")));
					(_entityToSpawn).getPersistentData().putDouble("ChestY", (entity.getPersistentData().getDouble("ChestY")));
					(_entityToSpawn).getPersistentData().putDouble("ChestZ", (entity.getPersistentData().getDouble("ChestZ")));
					_level.addFreshEntity(_entityToSpawn);
				}
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = BimbleModEntities.SUSUWATARI.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		}
	}
}
