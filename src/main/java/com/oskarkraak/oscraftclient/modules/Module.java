package com.oskarkraak.oscraftclient.modules;

import com.oskarkraak.oscraftclient.events.Event;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

import java.util.ArrayList;

public abstract class Module {

    private boolean enabled;
    private KeyBinding keyBinding;
    private String name;
    protected static final MinecraftClient minecraftClient = MinecraftClient.getInstance();
    ArrayList<Event> events = new ArrayList<Event>();

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