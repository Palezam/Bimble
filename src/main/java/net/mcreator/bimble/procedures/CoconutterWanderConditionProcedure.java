package net.mcreator.bimble.procedures;

import net.minecraft.world.entity.Entity;

public class CoconutterWanderConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("targetfound") == true) {
			return false;
		}
		return true;
	}
}
