package dev.minimalfps.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Removes the entire HUD (hotbar, crosshair, health, chat overlay)
@Mixin(targets = "net.minecraft.client.gui.Gui")
public class GuiMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true, require = 0)
    private void minimalfps$cancel(CallbackInfo ci) {
        ci.cancel();
    }
}
