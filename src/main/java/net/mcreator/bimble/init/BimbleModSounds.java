
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bimble.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.bimble.BimbleMod;

public class BimbleModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BimbleMod.MODID);
	public static final RegistryObject<SoundEvent> DRONEDELIVER = REGISTRY.register("dronedeliver", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bimble", "dronedeliver")));
	public static final RegistryObject<SoundEvent> THECOMPANYTHANKSYOUFORYOURSERVICE = REGISTRY.register("thecompanythanksyouforyourservice",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bimble", "thecompanythanksyouforyourservice")));
	public static final RegistryObject<SoundEvent> BIMBLETHANKSYOU = REGISTRY.register("bimblethanksyou", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bimble", "bimblethanksyou")));
	public static final RegistryObject<SoundEvent> ENJOY_YOUR_GUN = REGISTRY.register("enjoy_your_gun", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bimble", "enjoy_your_gun")));
	public static final RegistryObject<SoundEvent> RIPANDTEAR = REGISTRY.register("ripandtear", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bimble", "ripandtear")));
	public static final RegistryObject<SoundEvent> IT_IS_SAID_TO_LURE_CREATURES = REGISTRY.register("it_is_said_to_lure_creatures", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bimble", "it_is_said_to_lure_creatures")));
	public static final RegistryObject<SoundEvent> THANKYOUFORYOURSERVICE = REGISTRY.register("thankyouforyourservice", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("bimble", "thankyouforyourservice")));
}
