package com.oskarkraak.oscraftclient.modules;

import com.oskarkraak.oscraftclient.EventManager;
import com.oskarkraak.oscraftclient.events.KnockbackListener;
import net.minecraft.client.option.KeyBinding;

public class AntiKnockback extends Module implements KnockbackListener {

    public AntiKnockback(String name, KeyBinding keyBinding) {
        super(name, keyBinding);
        EventManager.LISTENERS.add(this);
    }

    @Override
    public void onKnockback(KnockbackEvent event)
    {
        if (isEnabled()) {
            event.setX(0);
            event.setY(0);
            event.setZ(0);
        }
    }

    @Override
    public void onEnable() {
        System.out.println("No Knockback");
    }

    @Override
    public void onDisable() {
        System.out.println("Knockback on");
    }

}
