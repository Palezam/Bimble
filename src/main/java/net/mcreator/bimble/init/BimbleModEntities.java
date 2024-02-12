
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
import net.mcreator.bimble.entity.DroneEntity;
import net.mcreator.bimble.entity.DoubleBarrelBulletsEntity;
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

					.sized(2f, 1.2f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DroneEntity.init();
			SusuwatariEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(DRONE.get(), DroneEntity.createAttributes().build());
		event.put(SUSUWATARI.get(), SusuwatariEntity.createAttributes().build());
	}
}
