package me.mical.particleview;

import me.mical.particleview.config.ConfigManager;
import org.serverct.parrot.parrotx.PPlugin;

public final class ParticleView extends PPlugin {

    @Override
    protected void preload() {
        pConfig = ConfigManager.getInstance();
    }
}
