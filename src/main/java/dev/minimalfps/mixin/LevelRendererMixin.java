package dev.minimalfps.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Skips ALL world rendering: sky, sun/moon, stars, clouds, chunks, entities, weather, outlines
@Mixin(targets = "net.minecraft.client.renderer.LevelRenderer")
public class LevelRendererMixin {
    @Inject(method = "renderLevel", at = @At("HEAD"), cancellable = true, require = 0)
    private void minimalfps$cancel(CallbackInfo ci) {
        ci.cancel();
    }
}
