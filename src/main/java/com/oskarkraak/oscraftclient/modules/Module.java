package com.oskarkraak.oscraftclient.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

public abstract class Module {

    private boolean enabled;
    private KeyBinding keyBinding;
    private String name;

    public Module(String name, KeyBinding keyBinding) {
        this.name = name;
        this.keyBinding = keyBinding;
    }

    public void enable() {
        enabled = true;
        onEnable();
    }

    public void disable() {
        enabled = false;
        onDisable();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public KeyBinding getKeyBinding() {
        return keyBinding;
    }

    public abstract void onEnable();

    public abstract void onDisable();
}