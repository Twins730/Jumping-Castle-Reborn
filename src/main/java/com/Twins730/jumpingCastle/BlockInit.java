package com.Twins730.jumpingCastle;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.*;

/**
 * Register the blocks for the mod
 * */
public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,JumpingCastle.MOD_ID);

    //Black and white Blocks
    public static final RegistryObject<Block> WHITE_INFLATABLE_CASTLE = BLOCKS.register("white_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> LIGHT_GRAY_INFLATABLE_CASTLE = BLOCKS.register("light_gray_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1.5f,1).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> GRAY_INFLATABLE_CASTLE = BLOCKS.register("gray_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> BLACK_INFLATABLE_CASTLE = BLOCKS.register("black_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1).sound(SoundType.WOOL)));

    //Colored Blocks
    public static final RegistryObject<Block> RED_INFLATABLE_CASTLE = BLOCKS.register("red_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> BROWN_INFLATABLE_CASTLE = BLOCKS.register("brown_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ORANGE_INFLATABLE_CASTLE = BLOCKS.register("orange_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> YELLOW_INFLATABLE_CASTLE = BLOCKS.register("yellow_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> LIME_INFLATABLE_CASTLE = BLOCKS.register("lime_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> GREEN_INFLATABLE_CASTLE = BLOCKS.register("green_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> LIGHT_BLUE_INFLATABLE_CASTLE = BLOCKS.register("light_blue_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1.5f,1f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> CYAN_INFLATABLE_CASTLE = BLOCKS.register("cyan_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> BLUE_INFLATABLE_CASTLE = BLOCKS.register("blue_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> PURPLE_INFLATABLE_CASTLE = BLOCKS.register("purple_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> MAGENTA_INFLATABLE_CASTLE = BLOCKS.register("magenta_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> PINK_INFLATABLE_CASTLE = BLOCKS.register("pink_inflatable_castle",()-> new InflatableBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1,1).sound(SoundType.WOOL)));

    //Others
    public static final RegistryObject<Block> CASTLE_NETTING = BLOCKS.register("castle_netting",()-> new PaneBlock(AbstractBlock.Properties.of(Material.WOOL).strength(1f,1f).sound(SoundType.WOOL)));

}
