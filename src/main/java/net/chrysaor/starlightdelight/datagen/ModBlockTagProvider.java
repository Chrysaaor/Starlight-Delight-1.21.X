package net.chrysaor.starlightdelight.datagen;

import net.chrysaor.starlightdelight.block.ModBlocks;
import net.chrysaor.starlightdelight.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)

                .add(ModBlocks.PINK_GARNET_SLABS)
                .add(ModBlocks.PINK_GARNET_FENCE)
                .add(ModBlocks.PINK_GARNET_FENCE_GATE)
                .add(ModBlocks.PINK_GARNET_WALL)
                .add(ModBlocks.PINK_GARNET_LAMP)
                .add(ModBlocks.PINK_GARNET_DOOR)
                .add(ModBlocks.PINK_GARNET_TRAPDOOR)
                .add(ModBlocks.PINK_GARNET_PRESSURE_PLATE)
                .add(ModBlocks.PINK_GARNET_BUTTON)
                .add(ModBlocks.PINK_GARNET_STAIRS)

                .add(ModBlocks.PEDESTAL)

                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.STARLIGHT_ORE)
                .add(ModBlocks.STARLIGHT_DEEPSLATE_ORE);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.FERMENTER)
                .add(ModBlocks.COOKING_TABLE);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.STARLIGHT_ORE)
                .add(ModBlocks.STARLIGHT_DEEPSLATE_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.PINK_GARNET_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PINK_GARNET_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.PINK_GARNET_WALL);
        getOrCreateTagBuilder(BlockTags.DOORS).add(ModBlocks.PINK_GARNET_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(ModBlocks.PINK_GARNET_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.BUTTONS).add(ModBlocks.PINK_GARNET_BUTTON);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PINK_GARNET_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.DRAKON_EGG_HATCH_BOOST)
                .add(Blocks.MAGMA_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_DRAKON_EGG_HATCH)
                .add(Blocks.OBSIDIAN)
                .add(Blocks.CRYING_OBSIDIAN);
    }
}
