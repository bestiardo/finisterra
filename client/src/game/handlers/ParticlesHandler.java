package game.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.utils.LongMap;
import game.AOGame;
import net.mostlyoriginal.api.system.core.PassiveSystem;

public class ParticlesHandler extends PassiveSystem {
    private static final LongMap<ParticleEffectPool> PARTICLES = new LongMap<>();

    public static ParticleEffect getParticle(int index) {
        return PARTICLES.get(index).obtain();
    }

    @Override
    protected void initialize() {
        super.initialize();
        AOGame game = (AOGame) Gdx.app.getApplicationListener();
        AOAssetManager assetManager = game.getAssetManager();
        PARTICLES.put(1, new ParticleEffectPool(assetManager.getParticle("blue-meditation.p"), 1, 100));
        PARTICLES.put(2, new ParticleEffectPool(assetManager.getParticle("aura1.party"), 1, 100));
        PARTICLES.put(3, new ParticleEffectPool(assetManager.getParticle("healing-2.p"), 20, 100));
        PARTICLES.put(4, new ParticleEffectPool(assetManager.getParticle("healing-2.p"), 20, 100));
        PARTICLES.put(5, new ParticleEffectPool(assetManager.getParticle("aura-red.p"), 20, 100));
        PARTICLES.put(6, new ParticleEffectPool(assetManager.getParticle("aura-blue.p"), 20, 100));
    }
}
