package com.Twins730.jumpingCastle;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Registers the sound for the mod.
 * */
public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,JumpingCastle.MOD_ID);

    //The one sound
    public static RegistryObject<SoundEvent> BOUNCE = SOUNDS.register("bounce",()-> new SoundEvent(new ResourceLocation(JumpingCastle.MOD_ID,"bounce")));

}
