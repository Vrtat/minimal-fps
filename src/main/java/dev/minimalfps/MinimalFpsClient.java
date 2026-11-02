package dev.minimalfps;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.CloudStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.ParticleStatus;

public class MinimalFpsClient implements ClientModInitializer {
    private boolean applied = false;

    @Override
    public void onInitializeClient() {
        // Options are fully loaded after the first tick, so apply them then.
        ClientTickEvents.END_CLIENT_TICK.register(mc -> {
            if (applied) return;
            applied = true;
            apply(mc);
        });
    }

    private static void apply(Minecraft mc) {
        Options o = mc.options;
        o.renderDistance().set(2);
        o.simulationDistance().set(5);
        o.framerateLimit().set(260);          // 260 = unlimited
        o.enableVsync().set(false);
        o.biomeBlendRadius().set(0);
        o.entityShadows().set(false);
        o.particles().set(ParticleStatus.MINIMAL);
        o.cloudStatus().set(CloudStatus.OFF);
        o.mipmapLevels().set(0);
        o.entityDistanceScaling().set(0.5);
        o.hideGui = true;
        o.getSoundSourceOptionInstance(net.minecraft.sounds.SoundSource.MASTER).set(0.0);
        o.save();
    }
}
