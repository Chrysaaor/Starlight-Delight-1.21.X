package net.chrysaor.starlightdelight.particle.custom;


import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class HoelyBeheaderSweepParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;

    HoelyBeheaderSweepParticle(ClientWorld world, double x, double y, double z, double d, SpriteProvider spriteProvider) {
        super(world, x, y, z, (double)0.0F, (double)0.0F, (double)0.0F);
        this.spriteProvider = spriteProvider;
        this.maxAge = 4;
        float f = this.alpha;
        this.red = f;
        this.green = f;
        this.blue = f;
        this.scale = 1.0F - (float)d * 0.5F;
        this.setSpriteForAge(spriteProvider);
    }

    public int getBrightness(int tint) {
        return 0;
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.setSpriteForAge(this.spriteProvider);
        }
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new HoelyBeheaderSweepParticle(clientWorld, d, e, f, g, this.spriteProvider);
        }
    }
}
