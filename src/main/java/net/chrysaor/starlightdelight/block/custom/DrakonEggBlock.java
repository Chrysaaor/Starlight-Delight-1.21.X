package net.chrysaor.starlightdelight.block.custom;

import com.mojang.serialization.MapCodec;
import net.chrysaor.starlightdelight.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class DrakonEggBlock extends Block {
    public static final MapCodec<DrakonEggBlock> CODEC = createCodec(DrakonEggBlock::new);
    public static final int FINAL_HATCH_STAGE = 2;
    public static final IntProperty HATCH;
    private static final int HATCHING_TIME = 72000;
    private static final int BOOSTED_HATCHING_TIME = 24000;
    private static final int MAX_RANDOM_CRACK_TIME_OFFSET = 300;
    private static final VoxelShape SHAPE;

    public MapCodec<DrakonEggBlock> getCodec() {
        return CODEC;
    }

    public DrakonEggBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(HATCH, 0));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HATCH);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public int getHatchStage(BlockState state) {
        return state.get(HATCH);
    }

    private boolean isReadyToHatch(BlockState state) {
        return this.getHatchStage(state) == 2;
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!this.isReadyToHatch(state)) {
            world.playSound(null, pos, SoundEvents.BLOCK_SNIFFER_EGG_CRACK, SoundCategory.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
            world.setBlockState(pos, state.with(HATCH, this.getHatchStage(state) + 1), 2);
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_SNIFFER_EGG_HATCH, SoundCategory.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
            world.breakBlock(pos, false);
            SnifferEntity snifferEntity = EntityType.SNIFFER.create(world);
            if (snifferEntity != null) {
                Vec3d vec3d = pos.toCenterPos();
                snifferEntity.setBaby(true);
                snifferEntity.refreshPositionAndAngles(vec3d.getX(), vec3d.getY(), vec3d.getZ(), MathHelper.wrapDegrees(world.random.nextFloat() * 360.0F), 0.0F);
                world.spawnEntity(snifferEntity);
            }

        }
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        boolean bl = isAboveHatchBooster(world, pos);
        boolean bl2 = isAboveHatchBlocker(world, pos);
        if (!world.isClient() && bl) {
            world.syncWorldEvent(3009, pos, 0);
        }

        if (bl2){
            world.emitGameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Emitter.of(state));
            return;
        }

        int i = bl ? 24000 : 72000;
        int j = i / 3;
        world.emitGameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Emitter.of(state));
        world.scheduleBlockTick(pos, this, j + world.random.nextInt(300));
    }

    public boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    public static boolean isAboveHatchBooster(BlockView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(ModTags.Blocks.DRAKON_EGG_HATCH_BOOST);
    }

    public static boolean isAboveHatchBlocker(BlockView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(ModTags.Blocks.INCORRECT_DRAKON_EGG_HATCH);
    }

    static {
        HATCH = Properties.HATCH;
        SHAPE = Block.createCuboidShape(1.0F, 0.0F, 2.0F, 15.0F, 16.0F, 14.0F);
    }
}
