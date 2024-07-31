package com.oskarkraak.oscraftclient;

import com.oskarkraak.oscraftclient.listeners.InGameHudRenderListener;
import com.oskarkraak.oscraftclient.listeners.TickListener.TickEvent;
import com.oskarkraak.oscraftclient.listeners.WorldCloseListener;
import com.oskarkraak.oscraftclient.modules.*;
import com.oskarkraak.oscraftclient.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;

public class ModuleManager implements InGameHudRenderListener, WorldCloseListener {

    private ArrayList<Module> modules = new ArrayList<>();
    //private KeyBinding o;

    public ModuleManager() {
        //o = new KeyBinding("o", GLFW.GLFW_KEY_O, "key.categories.movement");

        // Add all modules
        addModule(new GammaOverride("Gamma Override", new KeyBinding("g", GLFW.GLFW_KEY_G, "key.categories.hacks"))); // TODO not movement
        addModule(new AntiKnockback("Anti Knockback", new KeyBinding("k", GLFW.GLFW_KEY_K, "key.categories.hacks")));
        addModule(new NoFallDamage("NoFall", new KeyBinding("n", GLFW.GLFW_KEY_N, "key.categories.hacks")));
        addModule(new CreativeFlight("Creative Flight", new KeyBinding("v", GLFW.GLFW_KEY_V, "key.categories.hacks")));

        ClientTickEvents.START_CLIENT_TICK.register(minecraftClient -> {
            this.tick();
            new TickEvent().fire();
        });

        EventManager.LISTENERS.add(this);
    }

    public void tick() {
        // Get inputs
        for (Module m : modules) {
            if (m.getKeyBinding().wasPressed()) {
                if (m.isEnabled())
                    m.disable();
                else
                    m.enable();
            }
        }
    }

    public void addModule(Module m) {
        modules.add(m);
    }

    @Override
    public void onInGameHudRender(InGameHudRenderEvent event) {
        // Print a list of all enabled modules in the top left corner
        int i = 1;
        for (Module m : modules)
            if (m.isEnabled())
                MinecraftClient.getInstance().textRenderer.drawWithShadow(event.getMatrixStack(), m.getName(), 3F, i++ * 10F, 0xffffff);
    }

    @Override
    public void onWorldClose() {
        // Disable all modules
        for (Module m : modules)
            m.disable();
    }

}