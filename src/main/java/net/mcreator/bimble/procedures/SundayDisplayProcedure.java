package net.mcreator.bimble.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.bimble.network.BimbleModVariables;

public class SundayDisplayProcedure {
	public static boolean execute(LevelAccessor world) {
		if (BimbleModVariables.MapVariables.get(world).Day == 0) {
			return true;
		}
		return false;
	}
}
