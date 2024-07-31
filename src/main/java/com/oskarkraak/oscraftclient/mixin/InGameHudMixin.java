package com.oskarkraak.oscraftclient.mixin;

import com.oskarkraak.oscraftclient.listeners.InGameHudRenderListener.InGameHudRenderEvent;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "render", at = @At("RETURN"), cancellable = true)
    public void render(MatrixStack matrixStack, float tickDelta, CallbackInfo info) {
        new InGameHudRenderEvent(matrixStack, tickDelta).fire();
    }
}