package net.mcreator.bimble.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.bimble.network.BimbleModVariables;

public class ReturnSolariValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u00A73Solari: " + (entity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Solari;
	}
}
