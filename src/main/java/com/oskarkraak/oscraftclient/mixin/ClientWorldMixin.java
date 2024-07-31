package com.oskarkraak.oscraftclient.mixin;

import com.oskarkraak.oscraftclient.listeners.WorldCloseListener.WorldCloseEvent;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {

    @Inject(method = "disconnect", at = @At("RETURN"))
    public void disconnect(CallbackInfo ci) {
        new WorldCloseEvent().fire();
    }

}
