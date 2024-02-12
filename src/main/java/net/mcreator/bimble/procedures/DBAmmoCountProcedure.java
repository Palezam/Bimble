package net.mcreator.bimble.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.bimble.init.BimbleModItems;

public class DBAmmoCountProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == BimbleModItems.DOUBLE_BARREL.get()) {
			return true;
		}
		return false;
	}
}
