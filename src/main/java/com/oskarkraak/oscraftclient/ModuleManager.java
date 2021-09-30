package com.oskarkraak.oscraftclient;

import com.oskarkraak.oscraftclient.events.InGameHudRenderListener;
import com.oskarkraak.oscraftclient.events.TickListener;
import com.oskarkraak.oscraftclient.modules.*;
import com.oskarkraak.oscraftclient.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.math.MatrixStack;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;

public class ModuleManager implements InGameHudRenderListener {

    private ArrayList<Module> modules = new ArrayList<Module>();
    private KeyBinding o;

    public ModuleManager() {
        o = new KeyBinding("o", GLFW.GLFW_KEY_O, "key.categories.movement");

        // Add all modules
        addModule(new GammaOverride("Gamma Override", new KeyBinding("g", GLFW.GLFW_KEY_G, "key.categories.movement"))); // TODO not movement
        addModule(new AntiKnockback("Anti Knockback", new KeyBinding("k", GLFW.GLFW_KEY_K, "key.categories.movement")));

        ClientTickEvents.START_CLIENT_TICK.register(minecraftClient -> {
            this.tick();
            new TickListener.TickEvent().fire();
        });

        EventManager.LISTENERS.add(this);
    }

    public void tick() {
        // Get inputs
        for (Module m : modules) {
            if (o.isPressed() && m.getKeyBinding().wasPressed()) {
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

    public ArrayList<Module> getModules() {
        return modules;
    }

    @Override
    public void onInGameHudRender(InGameHudRenderEvent event) {
        int i = 1;
        for (Module m : modules)
            if (m.isEnabled())
                MinecraftClient.getInstance().textRenderer.drawWithShadow(event.getMatrixStack(), m.getName(), 3F, i++ * 10F, 0xffffff);
    }

}