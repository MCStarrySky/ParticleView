package me.mical.particleview.config;

import me.mical.particleview.ParticleView;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.config.PConfig;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoloadGroup;

import java.util.Objects;

@PAutoloadGroup
public class ConfigManager extends PConfig {

    private static ConfigManager instance;

    public ConfigManager() {
        super(ParrotXAPI.getPlugin(ParticleView.class), "config", "主配置文件");
    }

    public static ConfigManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ConfigManager();
        }
        return instance;
    }
}
