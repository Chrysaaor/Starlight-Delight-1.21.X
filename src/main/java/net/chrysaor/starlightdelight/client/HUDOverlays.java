package net.chrysaor.starlightdelight.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.LayeredDrawer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class HUDOverlays {

    public static int foodIconsOffset = 39;
    private static final Identifier MOD_ICONS_TEXTURE = Identifier.of(StarlightDelight.MOD_ID, "textures/gui/starlightdelight_icons.png");


    public static abstract class BaseOverlay implements LayeredDrawer.Layer
    {
        public abstract void render(MinecraftClient mc, PlayerEntity player, DrawContext guiGraphics, int left, int right, int top, int guiTicks);

        @Override
        public final void render(@NotNull DrawContext guiGraphics, @NotNull RenderTickCounter renderTickCounter) {
            MinecraftClient minecraft = MinecraftClient.getInstance();
            if (minecraft.player == null || !shouldRenderOverlay(minecraft, minecraft.player, guiGraphics, minecraft.inGameHud.getTicks()))
                return;

            int top = guiGraphics.getScaledWindowHeight();
            int left = guiGraphics.getScaledWindowWidth() / 2 - 91; // left of health bar
            int right = guiGraphics.getScaledWindowWidth() / 2 + 91; // right of food bar

            render(minecraft, minecraft.player, guiGraphics, left, right, top, minecraft.inGameHud.getTicks());
        }

        public boolean shouldRenderOverlay(MinecraftClient minecraft, PlayerEntity player, DrawContext guiGraphics, int guiTicks) {
            return !minecraft.options.hudHidden && player.isPartOfGame() && !player.isCreative();
        }
    }

    public static class SatiatedOverlay extends BaseOverlay
    {
        public static final Identifier ID = Identifier.of(StarlightDelight.MOD_ID, "satiated");

        // Refabricated
        public static final SatiatedOverlay INSTANCE = new SatiatedOverlay();

        @Override
        public void render(MinecraftClient minecraft, PlayerEntity player, DrawContext guiGraphics, int left, int right, int top, int guiTicks) {
            HungerManager stats = player.getHungerManager();

            boolean isPlayerHealingWithSaturation =
                    player.getWorld().getGameRules().getBoolean(GameRules.NATURAL_REGENERATION)
                            && player.canFoodHeal()
                            && stats.getSaturationLevel() > 0.0;

            if (player.getStatusEffect(ModEffects.SATIATED) != null) {
                drawSatiatedOverlay(stats, minecraft, guiGraphics, right, top - foodIconsOffset, isPlayerHealingWithSaturation);
            }
        }

        @Override
        public boolean shouldRenderOverlay(MinecraftClient mc, PlayerEntity player, DrawContext guiGraphics, int guiTicks) {
            return super.shouldRenderOverlay(mc, player, guiGraphics, guiTicks);
        }
    }

    public static void drawSatiatedOverlay(HungerManager foodData, MinecraftClient minecraft, DrawContext graphics, int right, int top, boolean naturalHealing) {
        int ticks = minecraft.inGameHud.getTicks();
        Random rand = new Random();
        rand.setSeed(ticks * 312871);

        RenderSystem.enableBlend();

        for (int j = 0; j < 10; ++j) {
            int x = right - j * 8 - 9;
            int y = top;


            // Background texture
            graphics.drawTexture(MOD_ICONS_TEXTURE, x, y, 0, 0, 9, 9);

            float effectiveHungerOfBar = (foodData.getFoodLevel()) / 2.0F - j;
            int naturalHealingOffset = naturalHealing ? 18 : 0;

            // Gilded hunger icons
            if (effectiveHungerOfBar >= 1)
                graphics.drawTexture(MOD_ICONS_TEXTURE, x, y, 18 + naturalHealingOffset, 0, 9, 9);
            else if (effectiveHungerOfBar >= .5)
                graphics.drawTexture(MOD_ICONS_TEXTURE, x, y, 9 + naturalHealingOffset, 0, 9, 9);
        }

        RenderSystem.disableBlend();
    }
}