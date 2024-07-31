package com.oskarkraak.oscraftclient.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

// TODO this is not the right way to do this (right now its fullbright)
public class GammaOverride extends Module {

    private double defaultGamma;
    private final MinecraftClient minecraftClient;

    public GammaOverride(String name, KeyBinding keyBinding) {
        super(name, keyBinding);
        minecraftClient = MinecraftClient.getInstance();
    }

    @Override
    public void onEnable() {
        defaultGamma = minecraftClient.options.gamma;
        // Set gamma to 1 -> full vision
        minecraftClient.options.gamma = 1;
    }

    @Override
    public void onDisable() {
        // Set gamma to default -> normal vision
        minecraftClient.options.gamma = defaultGamma;
    }

}