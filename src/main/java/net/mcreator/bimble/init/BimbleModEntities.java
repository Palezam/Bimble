
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bimble.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.bimble.entity.SusuwatariEntity;
import net.mcreator.bimble.entity.RoombaEntity;
import net.mcreator.bimble.entity.DroneEntity;
import net.mcreator.bimble.entity.DoubleBarrelBulletsEntity;
import net.mcreator.bimble.entity.CoconutterEntity;
import net.mcreator.bimble.entity.CoconutRangedItemEntity;
import net.mcreator.bimble.BimbleMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BimbleModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BimbleMod.MODID);
	public static final RegistryObject<EntityType<DroneEntity>> DRONE = register("drone",
			EntityType.Builder.<DroneEntity>of(DroneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DroneEntity::new)

					.sized(1f, 1.2f));
	public static final RegistryObject<EntityType<DoubleBarrelBulletsEntity>> DOUBLE_BARREL_BULLETS = register("projectile_double_barrel_bullets", EntityType.Builder.<DoubleBarrelBulletsEntity>of(DoubleBarrelBulletsEntity::new, MobCategory.MISC)
			.setCustomClientFactory(DoubleBarrelBulletsEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SusuwatariEntity>> SUSUWATARI = register("susuwatari",
			EntityType.Builder.<SusuwatariEntity>of(SusuwatariEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SusuwatariEntity::new)

					.sized(3f, 3f));
	public static final RegistryObject<EntityType<CoconutterEntity>> COCONUTTER = register("coconutter",
			EntityType.Builder.<CoconutterEntity>of(CoconutterEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(CoconutterEntity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<CoconutRangedItemEntity>> COCONUT = register("projectile_coconut", EntityType.Builder.<CoconutRangedItemEntity>of(CoconutRangedItemEntity::new, MobCategory.MISC)
			.setCustomClientFactory(CoconutRangedItemEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RoombaEntity>> ROOMBA = register("roomba",
			EntityType.Builder.<RoombaEntity>of(RoombaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RoombaEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DroneEntity.init();
			SusuwatariEntity.init();
			CoconutterEntity.init();
			RoombaEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(DRONE.get(), DroneEntity.createAttributes().build());
		event.put(SUSUWATARI.get(), SusuwatariEntity.createAttributes().build());
		event.put(COCONUTTER.get(), CoconutterEntity.createAttributes().build());
		event.put(ROOMBA.get(), RoombaEntity.createAttributes().build());
	}
}
