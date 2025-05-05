package net.chrysaor.starlightdelight.item;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModTemplateItem extends SmithingTemplateItem {
    private static final Formatting TITLE_FORMATTING;
    private static final Formatting DESCRIPTION_FORMATTING;
    private static final String TRANSLATION_KEY;
    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE;
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE;
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE;
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE;
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE;
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE;
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE;
    private final Text baseSlotDescriptionText;
    private final Text additionsSlotDescriptionText;
    private final List<Identifier> emptyBaseSlotTextures;
    private final List<Identifier> emptyAdditionsSlotTextures;


    private static final Text STARLIGHT_UPGRADE_TEXT;
    private static final Text STARLIGHT_UPGRADE_APPLIES_TO_TEXT;
    private static final Text STARLIGHT_UPGRADE_INGREDIENTS_TEXT;
    private static final Text STARLIGHT_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text STARLIGHT_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;


    public ModTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, FeatureFlag... requiredFeatures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures, requiredFeatures);
        this.baseSlotDescriptionText = baseSlotDescriptionText;
        this.additionsSlotDescriptionText = additionsSlotDescriptionText;
        this.emptyBaseSlotTextures = emptyBaseSlotTextures;
        this.emptyAdditionsSlotTextures = emptyAdditionsSlotTextures;
    }

    public static ModTemplateItem createStarlightUpgrade() {
        return new ModTemplateItem(STARLIGHT_UPGRADE_APPLIES_TO_TEXT, STARLIGHT_UPGRADE_INGREDIENTS_TEXT, STARLIGHT_UPGRADE_TEXT,
                STARLIGHT_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, STARLIGHT_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getStarlightUpgradeEmptyBaseSlotTextures(), getStarlightUpgradeEmptyAdditionsSlotTextures());
    }

    private static List<Identifier> getStarlightUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE, EMPTY_SLOT_HOE_TEXTURE);
    }

    private static List<Identifier> getStarlightUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }

    public Text getBaseSlotDescription() {
        return this.baseSlotDescriptionText;
    }

    public Text getAdditionsSlotDescription() {
        return this.additionsSlotDescriptionText;
    }

    public List<Identifier> getEmptyBaseSlotTextures() {
        return this.emptyBaseSlotTextures;
    }

    public List<Identifier> getEmptyAdditionsSlotTextures() {
        return this.emptyAdditionsSlotTextures;
    }

    public String getTranslationKey() {
        return TRANSLATION_KEY;
    }

    static {
        TITLE_FORMATTING = Formatting.GRAY;
        DESCRIPTION_FORMATTING = Formatting.BLUE;
        TRANSLATION_KEY = Util.createTranslationKey("item", Identifier.of(StarlightDelight.MOD_ID, "smithing_template"));
        EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_helmet");
        EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_chestplate");
        EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_leggings");
        EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE_TEXTURE = Identifier.ofVanilla("item/empty_slot_hoe");
        EMPTY_SLOT_AXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_axe");
        EMPTY_SLOT_SWORD_TEXTURE = Identifier.ofVanilla("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.ofVanilla("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_pickaxe");
        EMPTY_SLOT_INGOT_TEXTURE = Identifier.ofVanilla("item/empty_slot_ingot");

        STARLIGHT_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(StarlightDelight.MOD_ID, "starlight_upgrade"))).formatted(TITLE_FORMATTING);
        STARLIGHT_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(StarlightDelight.MOD_ID, "smithing_template.starlight_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
        STARLIGHT_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(StarlightDelight.MOD_ID, "smithing_template.starlight_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
        STARLIGHT_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(StarlightDelight.MOD_ID, "smithing_template.starlight_upgrade.base_slot_description")));
        STARLIGHT_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(StarlightDelight.MOD_ID, "smithing_template.starlight_upgrade.additions_slot_description")));
    }
}