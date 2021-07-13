package me.mical.particleview.command;

import me.mical.particleview.ParticleView;
import me.mical.particleview.command.impl.ReleaseCommand;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.command.subcommands.DebugCommand;
import org.serverct.parrot.parrotx.command.subcommands.HelpCommand;
import org.serverct.parrot.parrotx.command.subcommands.ReloadCommand;
import org.serverct.parrot.parrotx.command.subcommands.VersionCommand;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;

@PAutoload
public class CommandHandler extends org.serverct.parrot.parrotx.command.CommandHandler {

    public CommandHandler() {
        super(ParrotXAPI.getPlugin(ParticleView.class), "particleview");
        register(new HelpCommand(plugin));
        register(new ReloadCommand(plugin, ".reload"));
        register(new VersionCommand(plugin));
        register(new DebugCommand(plugin, ".debug"));
        register(new ReleaseCommand());
    }
}
