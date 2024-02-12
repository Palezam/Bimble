package net.mcreator.bimble.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

public class BulletParticleProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		world.addParticle(ParticleTypes.SMALL_FLAME, (entity.getX()), (entity.getY()), (entity.getZ()), 0, 1, 0);
		world.addParticle(ParticleTypes.SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 0, 1, 0);
		world.addParticle(ParticleTypes.SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 0, 1, 0);
		world.addParticle(ParticleTypes.SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 0, 1, 0);
	}
}
