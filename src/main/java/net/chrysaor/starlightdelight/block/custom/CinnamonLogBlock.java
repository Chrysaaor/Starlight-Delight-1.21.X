package net.chrysaor.starlightdelight.block.custom;

import net.chrysaor.starlightdelight.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CinnamonLogBlock extends PillarBlock {
    public CinnamonLogBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (player.getInventory().getMainHandStack().isIn(ItemTags.AXES)) {
            int j = 1 + world.random.nextInt(2);
            dropStack(world, pos, new ItemStack(ModItems.CINNAMON_BARK, j));
        }
        return super.onUse(state, world, pos, player, hit);
    }
}