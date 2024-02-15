package net.mcreator.bimble.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

public class DroneOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double x = 0;
		double y = 0;
		double z = 0;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("SearchName"))) {
				x = entityiterator.getX();
				y = entityiterator.getY();
				z = entityiterator.getZ();
			}
		}
		if (entity.getPersistentData().getBoolean("Attacked") == true) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo(x, y, z, 1000);
		} else {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo(x, (y + 1), z, 1);
		}
	}
}
