package net.chrysaor.starlightdelight.item;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.block.ModBlocks;
import net.chrysaor.starlightdelight.entity.ModEntities;
import net.chrysaor.starlightdelight.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;


public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));


    //Foods
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings()
            .food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.chrysaormod.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item SWEET_BERRIES_PIE = registerItem("sweet_berries_pie", new Item(new Item.Settings()
            .food(ModFoodComponents.SWEET_BERRIES_PIE)));
    public static final Item CHEESE = registerItem("cheese", new Item(new Item.Settings()
            .food(ModFoodComponents.CHEESE)));

    //
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings().fireproof()));
    public static final Item STARLIGHT_FRAGMENT = registerItem("starlight_fragment", new StarlightFragmentItem(new Item.Settings().fireproof()));

    public static final Item STARLIGHT_UPGRADE_SMITHING_TEMPLATE = registerItem("starlight_upgrade_smithing_template", ModTemplateItem.createStarlightUpgrade());

    //Starlight Armor
    public static final Item STARLIGHT_HELMET = registerItem("starlight_helmet",
            new StarlightArmorItem(ModArmorMaterials.STARLIGHT_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(20)).fireproof()));
    public static final Item STARLIGHT_CHESTPLATE = registerItem("starlight_chestplate",
            new StarlightArmorItem(ModArmorMaterials.STARLIGHT_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(20)).fireproof()));
    public static final Item STARLIGHT_LEGGINGS = registerItem("starlight_leggings",
            new StarlightArmorItem(ModArmorMaterials.STARLIGHT_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(20)).fireproof()));
    public static final Item STARLIGHT_BOOTS = registerItem("starlight_boots",
            new StarlightArmorItem(ModArmorMaterials.STARLIGHT_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20)).fireproof()));

    //Starlight Tools
    public static final Item STARLIGHT_HOE = registerItem("starlight_hoe",
            new StarlightHoeItem(ModToolMaterials.STARLIGHT_FRAGMENT, new Item.Settings()
                    .attributeModifiers(StarlightHoeItem.createAttributeModifiers(ModToolMaterials.STARLIGHT_FRAGMENT, -4.0F, 0.0F)).fireproof()));
    public static final Item STARLIGHT_PICKAXE = registerItem("starlight_pickaxe",
            new StarlightPickaxeItem(ModToolMaterials.STARLIGHT_FRAGMENT, new Item.Settings()
                    .attributeModifiers(StarlightPickaxeItem.createAttributeModifiers(ModToolMaterials.STARLIGHT_FRAGMENT, 1, -2.8f)).fireproof()));
    public static final Item STARLIGHT_AXE = registerItem("starlight_axe",
            new StarlightAxeItem(ModToolMaterials.STARLIGHT_FRAGMENT, new Item.Settings()
                    .attributeModifiers(StarlightAxeItem.createAttributeModifiers(ModToolMaterials.STARLIGHT_FRAGMENT, 6, -3.2f)).fireproof()));
    public static final Item STARLIGHT_SHOVEL = registerItem("starlight_shovel",
            new StarlightShovelItem(ModToolMaterials.STARLIGHT_FRAGMENT, new Item.Settings()
                    .attributeModifiers(StarlightShovelItem.createAttributeModifiers(ModToolMaterials.STARLIGHT_FRAGMENT, 1.5F, -3.0f)).fireproof()));
    public static final Item STARLIGHT_BOW = registerItem("starlight_bow",
            new StarlightBowItem(new Item.Settings().maxDamage(600).fireproof()));
    public static final Item STARLIGHT_SWORD = registerItem("starlight_sword",
            new StarlightSwordItem(ModToolMaterials.STARLIGHT_FRAGMENT, new Item.Settings()
                    .attributeModifiers(StarlightSwordItem.createAttributeModifiers(ModToolMaterials.STARLIGHT_FRAGMENT, 3, -2.2F)).fireproof()));

    //Pink Garnet Tools
    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",
            new PinkGarnetSwordItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 2, -2.4f))));
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",
            new PinkGarnetPickaxeItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 1, -2.8f))));
    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",
            new PinkGarnetShovelItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 1.5f, -3.0f))));
    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",
            new PinkGarnetAxeItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 6, -3.2f))));
    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",
            new PinkGarnetHoeItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 0, -3f))));

    //Hammers
    public static final Item PINK_GARNET_HAMMER = registerItem("pink_garnet_hammer",
            new PinkGarnetHammerItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 3, -3.4f))));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -3.4f))));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -3.4f))));
    public static final Item STARLIGHT_HAMMER = registerItem("starlight_hammer",
            new StarlightHammerItem(ModToolMaterials.STARLIGHT_FRAGMENT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STARLIGHT_FRAGMENT, 3, -3.4f))));

    //Hoely Beheader
    public static final Item HOELY_BEHEADER = registerItem("hoely_beheader",
            new HoelyBeheaderItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2f))
                    .fireproof()
                    .rarity(Rarity.EPIC)) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.chrysaormod.hoely_beheader.tooltip"));
            tooltip.add(Text.translatable("tooltip.chrysaormod.hoely_beheader.tooltip1"));
            tooltip.add(Text.translatable("tooltip.chrysaormod.hoely_beheader.tooltip2"));
            tooltip.add(Text.translatable("tooltip.chrysaormod.hoely_beheader.tooltip3"));
            tooltip.add(Text.translatable("tooltip.chrysaormod.hoely_beheader.tooltip4"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    //Pink Garnet Armor
    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
        new PinkGarnetArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(20))));
    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
        new PinkGarnetArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(20))));
    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings",
        new PinkGarnetArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(20))));
    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
        new PinkGarnetArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20))));

    public static final Item PINK_GARNET_HORSE_ARMOR = registerItem("pink_garnet_horse_armor",
        new AnimalArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

    public static final Item IRON_TOMAHAWK = registerItem("iron_tomahawk",
            new TomahawkItem(new Item.Settings().maxCount(16)));
    public static final Item GOLD_TOMAHAWK = registerItem("gold_tomahawk",
            new TomahawkItem(new Item.Settings().maxCount(32)));
    public static final Item PINK_GARNET_TOMAHAWK = registerItem("pink_garnet_tomahawk",
            new PinkGarnetTomahawkItem(new Item.Settings().maxCount(16)));
    public static final Item DIAMOND_TOMAHAWK = registerItem("diamond_tomahawk",
            new TomahawkItem(new Item.Settings().maxCount(16)));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
        new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new Item.Settings()));

    public static final Item MANTIS_SPAWN_EGG = registerItem("mantis_spawn_egg",
            new SpawnEggItem(ModEntities.MANTIS, 0x9dc783, 0xbfaf5f, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StarlightDelight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        StarlightDelight.LOGGER.info("Registering Mod Items for " + StarlightDelight.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
           entries.add(PINK_GARNET);
           entries.add(RAW_PINK_GARNET);
        });
    }
}
