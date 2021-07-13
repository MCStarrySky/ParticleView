package me.mical.particleview.command.impl;

import me.mical.particleview.ParticleView;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.command.BaseCommand;
import org.serverct.parrot.parrotx.utils.EnumUtil;
import org.serverct.parrot.parrotx.utils.i18n.I18n;
import xyz.xenondevs.particle.ParticleBuilder;
import xyz.xenondevs.particle.ParticleEffect;

import java.util.Objects;
import java.util.stream.Collectors;

public class ReleaseCommand extends BaseCommand {

    public ReleaseCommand() {
        super(ParrotXAPI.getPlugin(ParticleView.class), "release", 1);

        mustPlayer(true);
        perm(".release");
        describe("释放一个粒子效果");

        addParam(CommandParam.builder()
                .name("粒子效果 ID")
                .description("指定粒子效果的英文名称")
                .position(0)
                .suggest(() -> ParticleEffect.VALUES.stream()
                        .map(ParticleEffect::name)
                        .collect(Collectors.toList())
                        .toArray(new String[0]))
                .validate(effect -> Objects.nonNull(EnumUtil.valueOf(ParticleEffect.class, effect)))
                .advancedValidateMessage(args -> warn("你输入的 &c{0} &r特效不存在...", args[0]))
                .converter(args -> ParticleEffect.valueOf(args[0]))
                .build());
    }

    @Override
    protected void call(String[] args) {
        final ParticleEffect effect = convert(0, args, ParticleEffect.class);
        assert effect != null;
        new ParticleBuilder(effect)
                .setLocation(user.getLocation())
                .display();
        user.sendMessage(info("已成功为您释放 &c{0} &r特效.", effect.name()));
    }
}
