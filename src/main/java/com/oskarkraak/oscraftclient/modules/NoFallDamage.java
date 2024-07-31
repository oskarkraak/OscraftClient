package com.oskarkraak.oscraftclient.modules;

import com.oskarkraak.oscraftclient.EventManager;
import com.oskarkraak.oscraftclient.listeners.TickListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class NoFallDamage extends Module implements TickListener {

    public NoFallDamage(String name, KeyBinding keyBinding) {
        super(name, keyBinding);
    }

    @Override
    public void onTick() {
        MinecraftClient.getInstance().player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
    }

    @Override
    public void onEnable() {
        EventManager.LISTENERS.add(this);
    }

    @Override
    public void onDisable() {
        EventManager.LISTENERS.remove(this);
    }

}
