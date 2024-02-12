package net.mcreator.bimble.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.bimble.entity.DroneEntity;
import net.mcreator.bimble.BimbleMod;

public class DroneEntityIsHurtProcedure {
	public static String execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return "";
		if (sourceentity instanceof Player) {
			entity.getPersistentData().putDouble("DroneAnimation", 2);
			if ((sourceentity.getDisplayName().getString()).equals(entity.getPersistentData().getString("SearchName")) == true) {
				sourceentity.getPersistentData().putBoolean("HasOrder", false);
			}
			entity.getPersistentData().putBoolean("Attacked", true);
			if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
				_entity.setTarget(_ent);
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())));
			BimbleMod.queueServerWork(40, () -> {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 5, Level.ExplosionInteraction.NONE);
				if (entity instanceof DroneEntity) {
					entity.getPersistentData().putDouble("DroneAnimation", 0);
					if (!entity.level().isClientSide())
						entity.discard();
				}
			});
			return "hit";
		}
		return "false";
	}
}
