package net.mcreator.bimble.procedures;

import net.minecraft.world.entity.Entity;

public class DronePlayReturnedAnimationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDouble("DroneAnimation") == 1) {
			return "deliver";
		}
		if (entity.getPersistentData().getDouble("DroneAnimation") == 2) {
			return "hit";
		}
		return "false";
	}
}
