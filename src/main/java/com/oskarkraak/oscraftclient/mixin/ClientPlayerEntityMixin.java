package com.oskarkraak.oscraftclient.mixin;

import com.mojang.authlib.GameProfile;
import com.oskarkraak.oscraftclient.listeners.KnockbackListener.KnockbackEvent;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {

    public ClientPlayerEntityMixin(ClientWorld clientWorld_1,
                                   GameProfile gameProfile_1) {
        super(clientWorld_1, gameProfile_1);
    }

    @Override
    public void setVelocityClient(double x, double y, double z) {
        KnockbackEvent event = new KnockbackEvent(x, y, z);
        event.fire();
        super.setVelocityClient(event.getX(), event.getY(), event.getZ());
    }

    /*@Inject(at = {@At("HEAD")},
            method = {
                    "move(Lnet/minecraft/entity/MovementType;Lnet/minecraft/util/math/Vec3d;)V"})
    private void onMove(MovementType type, Vec3d offset, CallbackInfo ci) {
    }*/

}
