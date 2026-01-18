package net.chrysaor.starlightdelight.block.custom;

import com.mojang.serialization.MapCodec;
import net.chrysaor.starlightdelight.screen.custom.PreparationTableScreenHandler;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class PreparationTableBlock  extends CraftingTableBlock {
    public static final MapCodec<PreparationTableBlock> CODEC = PreparationTableBlock.createCodec(PreparationTableBlock::new);
    private static final Text SCREEN_TITLE = Text.translatable("container.starlightdelight.preparation_table");

    public MapCodec<PreparationTableBlock> getCodec() {
        return CODEC;
    }

    public PreparationTableBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH -> {
                return NORTH_SHAPE;
            }
            case SOUTH -> {
                return SOUTH_SHAPE;
            }
            case EAST -> {
                return EAST_SHAPE;
            }
            case WEST -> {
                return WEST_SHAPE;
            }
            default -> {
                return NORTH_SHAPE;
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new PreparationTableScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), SCREEN_TITLE);
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory handledScreen = state.createScreenHandlerFactory(world, pos);

            if (handledScreen != null) {
                player.openHandledScreen(handledScreen);
            }
        }

        return ActionResult.SUCCESS;
    }

    private static final VoxelShape NORTH_SHAPE =
            Block.createCuboidShape(0, 0, 0, 16, 16, 14);
    private static final VoxelShape WEST_SHAPE =
            Block.createCuboidShape(0, 0, 0, 14, 16, 16);
    private static final VoxelShape SOUTH_SHAPE =
            Block.createCuboidShape(0, 0, 2, 16, 16, 16);
    private static final VoxelShape EAST_SHAPE =
            Block.createCuboidShape(2, 0, 0, 16, 16, 16);

    public static final DirectionProperty FACING;

    static {
        FACING = HorizontalFacingBlock.FACING;
    }
}