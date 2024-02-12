
package net.mcreator.bimble.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.bimble.procedures.StarCandyPlayerFinishesUsingItemProcedure;

public class StarCandyItem extends Item {
	public StarCandyItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(1f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 12;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		StarCandyPlayerFinishesUsingItemProcedure.execute(entity);
		return retval;
	}
}
