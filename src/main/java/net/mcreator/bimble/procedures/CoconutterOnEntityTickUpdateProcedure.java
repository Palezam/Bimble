package net.mcreator.bimble.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.util.Comparator;

public class CoconutterOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack targeteditem = ItemStack.EMPTY;
		double itemx = 0;
		double itemy = 0;
		double itemz = 0;
		Entity target = null;
		if (((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 12, 12, 12), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof ItemEntity
				&& ((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 12, 12, 12), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).onGround()) {
			entity.getPersistentData().putBoolean("targetfound", true);
			target = (Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 12, 12, 12), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
			itemx = target.getX();
			itemy = target.getY();
			itemz = target.getZ();
			targeteditem = (target instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY);
			if (targeteditem.getItem() == Blocks.OBSIDIAN.asItem()) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo(itemx, itemy, itemz, 1.2);
				if (entity.getX() == itemx && entity.getZ() == itemz) {
					entity.getPersistentData().putBoolean("targetfound", false);
					if (!target.level().isClientSide())
						target.discard();
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Blocks.SAND));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
