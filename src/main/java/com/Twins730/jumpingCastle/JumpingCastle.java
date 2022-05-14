package com.Twins730.jumpingCastle;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(JumpingCastle.MOD_ID)
@Mod.EventBusSubscriber(modid = JumpingCastle.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JumpingCastle {
    public static final String MOD_ID = "jumping_castle";
    public static final Logger LOGGER = LogManager.getLogger();

    public JumpingCastle() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        SoundInit.SOUNDS.register(bus);
        BlockInit.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        RenderTypeLookup.setRenderLayer(BlockInit.CASTLE_NETTING.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().tab(ItemGroup.TAB_DECORATIONS);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
        LOGGER.debug("Registered BlockItems!");
    }
}
