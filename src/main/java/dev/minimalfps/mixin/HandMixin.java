package dev.minimalfps.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Skips first-person hand and held item
@Mixin(targets = "net.minecraft.client.renderer.ItemInHandRenderer")
public class HandMixin {
    @Inject(method = "renderHandsWithItems", at = @At("HEAD"), cancellable = true, require = 0)
    private void minimalfps$cancel(CallbackInfo ci) {
        ci.cancel();
    }
}
