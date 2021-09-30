package com.oskarkraak.oscraftclient;

import com.oskarkraak.oscraftclient.events.Listener;
import com.oskarkraak.oscraftclient.modules.AntiKnockback;
import com.oskarkraak.oscraftclient.modules.Module;
import net.minecraft.client.network.AbstractClientPlayerEntity;

import java.util.ArrayList;

public class EventManager {

    public static final ArrayList<Listener> LISTENERS = new ArrayList<>();
    private static ModuleManager moduleManager;

    public EventManager(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

}
