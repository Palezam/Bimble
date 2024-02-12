package net.mcreator.bimble.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.bimble.network.BimbleModVariables;
import net.mcreator.bimble.init.BimbleModEntities;

public class BuyAppleProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("HasOrder") == false) {
			if ((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Solari >= 6) {
				{
					double _setval = (entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Solari - 6;
					entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Solari = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
				{
					double _setval = 1;
					entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.OrderType = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level) {
					Entity _entityToSpawn = BimbleModEntities.DRONE.get().create(_level);
					_entityToSpawn.moveTo((entity.getX()), (entity.getY() + 1), (entity.getZ()), world.getRandom().nextFloat() * 360.0F, 0.0F);
					if (_entityToSpawn instanceof Mob _mobToSpawn) {
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(_entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					}
					(_entityToSpawn).getPersistentData().putString("SearchName", (entity.getDisplayName().getString()));
					_level.addFreshEntity(_entityToSpawn);
				}
				entity.getPersistentData().putBoolean("HasOrder", true);
			} else {
				if (entity instanceof Player _player)
					_player.closeContainer();
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cInsufficient Funds!"), true);
			}
		} else if (entity.getPersistentData().getBoolean("HasOrder") == true) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cOrder already placed!"), true);
		}
	}
}
