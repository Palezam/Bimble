package net.mcreator.bimble.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.bimble.network.BimbleModVariables;
import net.mcreator.bimble.BimbleMod;

public class ClawMachinebuttonPressProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Solari >= 20) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			{
				double _setval = (entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Solari - 20;
				entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Solari = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
					world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
			}
			{
				int _value = 2;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			BimbleMod.queueServerWork(260, () -> {
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			});
		} else {
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cInsufficient Funds!"), true);
		}
	}
}
