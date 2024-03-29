package net.mcreator.bimble.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.bimble.init.BimbleModItems;
import net.mcreator.bimble.entity.SusuwatariEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SootGuyRightClickedProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack saveditem = ItemStack.EMPTY;
		double amount = 0;
		if (sourceentity instanceof Player && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BOWL && entity instanceof SusuwatariEntity) {
			amount = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount();
			if (amount == 1) {
				if (sourceentity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(BimbleModItems.BOWL_OF_SOOT.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				saveditem = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			} else {
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.BOWL);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) amount, _player.inventoryMenu.getCraftSlots());
				}
				if (sourceentity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(BimbleModItems.BOWL_OF_SOOT.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.BOWL);
					_setstack.setCount((int) (amount - 1));
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				saveditem = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			}
			saveditem.getOrCreateTag().putDouble("savedhealth", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
			if (!(entity.getDisplayName().getString()).equals("Susuwatari")) {
				saveditem.setHoverName(Component.literal(("\u00A7fBowl of " + entity.getDisplayName().getString())));
				saveditem.getOrCreateTag().putString("savedname", (entity.getDisplayName().getString()));
			}
			if (entity.getPersistentData().getBoolean("HasCoal") == true) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Items.COAL));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (entity instanceof SusuwatariEntity) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		} else if (sourceentity instanceof Player && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == BimbleModItems.STAR_CANDY.get() && entity instanceof SusuwatariEntity) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == BimbleModItems.STAR_CANDY.get()) {
				if (sourceentity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(BimbleModItems.STAR_CANDY.get());
					_setstack.setCount((int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1));
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(BimbleModItems.STAR_CANDY.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
					world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
			}
			if (entity instanceof SusuwatariEntity) {
				((SusuwatariEntity) entity).setAnimation("eat");
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HEART, (entity.getX()), (entity.getY()), (entity.getZ()), 2, 0.6, 0.6, 0.6, 1);
		}
	}
}
