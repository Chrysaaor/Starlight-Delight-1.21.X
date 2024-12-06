package net.chrysaor.chrysaormod.util;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_PINK_GARNET_TOOL = createTag("needs_pink_garnet_tool");
        public static final TagKey<Block> INCORRECT_FOR_PINK_GARNET_TOOL = createTag("incorrect_for_pink_garnet_tool");

        public static final TagKey<Block> INCORRECT_FOR_STARLIGHT_TOOL = createTag("incorrect_for_starlight_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ChrysaorMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        public static final TagKey<Item> STARLIGHT_FOOT_ARMOR = createTag("starlight_foot_armor");
        public static final TagKey<Item> STARLIGHT_LEG_ARMOR = createTag("starlight_leg_armor");
        public static final TagKey<Item> STARLIGHT_CHEST_ARMOR = createTag("starlight_chest_armor");
        public static final TagKey<Item> STARLIGHT_HEAD_ARMOR = createTag("starlight_head_armor");
        public static final TagKey<Item> STARLIGHT_PICKAXE = createTag("starlight_pickaxe");
        public static final TagKey<Item> STARLIGHT_AXE = createTag("starlight_axe");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ChrysaorMod.MOD_ID, name));
        }
    }
}
