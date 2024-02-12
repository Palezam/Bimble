package net.mcreator.bimble.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.bimble.network.BimbleModVariables;
import net.mcreator.bimble.init.BimbleModItems;
import net.mcreator.bimble.entity.DroneEntity;
import net.mcreator.bimble.BimbleMod;

public class DroneRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			double _setval = 0;
			sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Voiceline = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		if (sourceentity.getPersistentData().getBoolean("HasOrder") == true) {
			if ((sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).OrderType == 1) {
				sourceentity.getPersistentData().putBoolean("HasOrder", false);
				{
					double _setval = Math.random();
					sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Voiceline = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				entity.getPersistentData().putDouble("DroneAnimation", 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:dronedeliver")), SoundSource.NEUTRAL, (float) 0.4, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:dronedeliver")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
					}
				}
				BimbleMod.queueServerWork(20, () -> {
					for (int index0 = 0; index0 < 32; index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(BimbleModItems.STAR_CANDY.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					entity.getPersistentData().putDouble("DroneAnimation", 0);
					BimbleMod.queueServerWork(60, () -> {
						if ((sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Voiceline < 0.5) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:it_is_said_to_lure_creatures")), SoundSource.NEUTRAL,
											(float) 0.5, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:it_is_said_to_lure_creatures")), SoundSource.NEUTRAL, (float) 0.5, 1,
											false);
								}
							}
							BimbleMod.queueServerWork(15, () -> {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("It is said to lure creatures that live that live in the ashes. "), true);
							});
						} else if ((sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Voiceline < 0.5 * 2) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:thankyouforyourservice")), SoundSource.NEUTRAL,
											(float) 0.5, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:thankyouforyourservice")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
							BimbleMod.queueServerWork(15, () -> {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Thank you for your service."), true);
							});
						}
						BimbleMod.queueServerWork(300, () -> {
							if (entity instanceof DroneEntity) {
								if (!entity.level().isClientSide())
									entity.discard();
							}
						});
					});
				});
			}
			if ((sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).OrderType == 2) {
				sourceentity.getPersistentData().putBoolean("HasOrder", false);
				{
					double _setval = Math.random();
					sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Voiceline = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				entity.getPersistentData().putDouble("DroneAnimation", 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:dronedeliver")), SoundSource.NEUTRAL, (float) 0.4, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:dronedeliver")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
					}
				}
				BimbleMod.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(BimbleModItems.DOUBLE_BARREL.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					for (int index1 = 0; index1 < 8; index1++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(BimbleModItems.SHOTGUN_SHELL.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					entity.getPersistentData().putDouble("DroneAnimation", 0);
					BimbleMod.queueServerWork(60, () -> {
						if ((sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Voiceline < 0.2) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:enjoy_your_gun")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:enjoy_your_gun")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
							BimbleMod.queueServerWork(15, () -> {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Enjoy your gun."), true);
							});
						} else if ((sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Voiceline < 0.2 * 2) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:thankyouforyourservice")), SoundSource.NEUTRAL,
											(float) 0.5, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:thankyouforyourservice")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
							BimbleMod.queueServerWork(15, () -> {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Thank you for your service."), true);
							});
						} else if ((sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Voiceline < 0.2 * 3) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:ripandtear")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:ripandtear")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
							BimbleMod.queueServerWork(15, () -> {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Rip and tear."), true);
							});
						} else if ((sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Voiceline < 0.2 * 4) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:thecompanythanksyouforyourservice")), SoundSource.NEUTRAL,
											(float) 0.5, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:thecompanythanksyouforyourservice")), SoundSource.NEUTRAL, (float) 0.5, 1,
											false);
								}
							}
							BimbleMod.queueServerWork(15, () -> {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("The company thanks you for your service."), true);
							});
						} else if ((sourceentity.getCapability(BimbleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BimbleModVariables.PlayerVariables())).Voiceline < 0.2 * 5) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:bimblethanksyou")), SoundSource.NEUTRAL, (float) 0.5, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bimble:bimblethanksyou")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
								}
							}
							BimbleMod.queueServerWork(15, () -> {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Bimble thanks you for your service."), true);
							});
						}
						BimbleMod.queueServerWork(300, () -> {
							if (entity instanceof DroneEntity) {
								if (!entity.level().isClientSide())
									entity.discard();
							}
						});
					});
				});
			}
		}
	}
}
