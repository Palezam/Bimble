package net.mcreator.bimble.procedures;

import net.minecraft.world.entity.Entity;

public class SusuwatariLoopExternalAnimationsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("HasCoal") == true) {
			return true;
		}
		return false;
	}
}
