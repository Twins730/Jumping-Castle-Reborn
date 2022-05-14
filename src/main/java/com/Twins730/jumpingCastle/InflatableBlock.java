package com.Twins730.jumpingCastle;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
/**
 * The main class for the Inflatable block where everything is handled!
 * */
public class InflatableBlock extends Block {

    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public InflatableBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TYPE, Type.NONE));
    }

    @Override
    public void updateEntityAfterFallOn(IBlockReader p_176216_1_, Entity entity) {
        if (entity instanceof LivingEntity) {
            if (!entity.isShiftKeyDown()) {
                bounceUp(entity);
            }
        }
    }

    private void bounceUp(Entity entity) {
        entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0, 0.0, 1.0));
        entity.push(0, 0.9f, 0);
    }

    @Override
    public void fallOn(World level, BlockPos pos, Entity entity, float fallDistance) {
        if (entity instanceof LivingEntity) {
            if (!entity.isShiftKeyDown()) {
                if (level.isClientSide) {
                    for (int i = 0; i < 5; i++) {
                        level.addParticle(ParticleTypes.ENTITY_EFFECT, entity.xo, entity.yo, entity.zo, 1.0, 1.0, 1.0);
                    }
                } else {
                    level.playSound(null, pos, SoundInit.BOUNCE.get(), SoundCategory.BLOCKS, 1.0F, level.random.nextFloat() * 0.2F + 0.9F);
                }
            }
            entity.fallDistance = 0;
        }

    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState neghbor_state, IWorld world, BlockPos blockPos, BlockPos pos) {

        boolean north = world.getBlockState(blockPos.north()).getBlock() instanceof InflatableBlock;
        boolean east = world.getBlockState(blockPos.east()).getBlock() instanceof InflatableBlock;
        boolean south = world.getBlockState(blockPos.south()).getBlock() instanceof InflatableBlock;
        boolean west = world.getBlockState(blockPos.west()).getBlock() instanceof InflatableBlock;

        world.getBlockTicks().scheduleTick(blockPos, this, 1);

        //Thanks to MrCrayFish for figuring these out for me.
        if (!north && !east && !south && !west) {
            return blockState.setValue(TYPE, Type.NONE);
        }
        if (!north && !east && south && !west) {
            return blockState.setValue(TYPE, Type.NORTH);
        }
        if (north && !east && !south && !west) {
            return blockState.setValue(TYPE, Type.SOUTH);
        }
        if (!north && !east && !south && west) {
            return blockState.setValue(TYPE, Type.EAST);
        }
        if (!north && east && !south && !west) {
            return blockState.setValue(TYPE, Type.WEST);
        }
        if (north && !east && south && !west) {
            return blockState.setValue(TYPE, Type.HORIZONTAL_NORTH_SOUTH);
        }
        if (!north && east && !south && west) {
            return blockState.setValue(TYPE, Type.HORIZONTAL_EAST_WEST);
        }
        if (!north && east && south && !west) {
            return blockState.setValue(TYPE, Type.CORNER_EAST_SOUTH);
        }
        if (!north && !east && south && west) {
            return blockState.setValue(TYPE, Type.CORNER_WEST_SOUTH);
        }
        if (north && east && !south && !west) {
            return blockState.setValue(TYPE, Type.CORNER_NORTH_EAST);
        }
        if (north && !east && !south && west) {
            return blockState.setValue(TYPE, Type.CORNER_NORTH_WEST);
        }
        if (!north && east && south && west) {
            return blockState.setValue(TYPE, Type.THREE_NORTH);
        }
        if (north && !east && south && west) {
            return blockState.setValue(TYPE, Type.THREE_EAST);
        }
        if (north && east && !south && west) {
            return blockState.setValue(TYPE, Type.THREE_SOUTH);
        }
        if (north && east && south && !west) {
            return blockState.setValue(TYPE, Type.THREE_WEST);
        }
        return blockState.setValue(TYPE, Type.CENTER);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(TYPE, Type.NONE);

    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }

    public enum Type implements IStringSerializable {

        NONE("none"),
        NORTH("north"),
        EAST("east"),
        SOUTH("south"),
        WEST("west"),
        HORIZONTAL_EAST_WEST("horizontal_east_west"),
        HORIZONTAL_NORTH_SOUTH("horizontal_north_south"),
        CORNER_EAST_SOUTH("corner_east_south"),
        CORNER_WEST_SOUTH("corner_west_south"),
        CORNER_NORTH_EAST("corner_north_east"),
        CORNER_NORTH_WEST("corner_north_west"),
        THREE_NORTH("three_north"),
        THREE_EAST("three_east"),
        THREE_SOUTH("three_south"),
        THREE_WEST("three_west"),
        CENTER("center");

        private final String name;

        private Type(String p_i49335_3_) {
            this.name = p_i49335_3_;
        }

        public String toString() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}