package com.oskarkraak.oscraftclient.modules;

import com.oskarkraak.oscraftclient.EventManager;
import com.oskarkraak.oscraftclient.listeners.TickListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

public class CreativeFlight extends Module implements TickListener {

    public CreativeFlight(String name, KeyBinding keyBinding) {
        super(name, keyBinding);
    }

    @Override
    public void onTick() {
        MinecraftClient.getInstance().player.getAbilities().allowFlying = true;
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
