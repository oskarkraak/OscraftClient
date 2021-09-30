package com.oskarkraak.oscraftclient.modules;

import com.oskarkraak.oscraftclient.EventManager;
import com.oskarkraak.oscraftclient.events.TickListener;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.text.Text;

public class GammaOverride extends Module implements TickListener {

    double defaultGamma;

    public GammaOverride(String name, KeyBinding keyBinding) {
        super(name, keyBinding);
        EventManager.LISTENERS.add(this);
    }

    @Override
    public void onEnable() {
        // Set gamma to 1 -> full vision
        minecraftClient.options.gamma = 1;
    }

    @Override
    public void onDisable() {
        // Set gamma to default -> normal vision
        minecraftClient.options.gamma = defaultGamma;
    }

    @Override
    public void onTick() {
        // If defaultGamma is 0 it might not have been initialized
        if (defaultGamma == 0)
            defaultGamma = minecraftClient.options.gamma;
    }
}