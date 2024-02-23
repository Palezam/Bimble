
package net.mcreator.bimble.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.bimble.init.BimbleModItems;
import net.mcreator.bimble.init.BimbleModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class CoconutRangedItemEntity extends AbstractArrow implements ItemSupplier {
	public CoconutRangedItemEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(BimbleModEntities.COCONUT.get(), world);
	}

	public CoconutRangedItemEntity(EntityType<? extends CoconutRangedItemEntity> type, Level world) {
		super(type, world);
	}

	public CoconutRangedItemEntity(EntityType<? extends CoconutRangedItemEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public CoconutRangedItemEntity(EntityType<? extends CoconutRangedItemEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(BimbleModItems.COCONUT.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(BimbleModItems.COCONUT.get());
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static CoconutRangedItemEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		CoconutRangedItemEntity entityarrow = new CoconutRangedItemEntity(BimbleModEntities.COCONUT.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static CoconutRangedItemEntity shoot(LivingEntity entity, LivingEntity target) {
		CoconutRangedItemEntity entityarrow = new CoconutRangedItemEntity(BimbleModEntities.COCONUT.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(2);
		entityarrow.setKnockback(1);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}
