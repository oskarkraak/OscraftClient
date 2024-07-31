package com.oskarkraak.oscraftclient;

import com.oskarkraak.oscraftclient.listeners.Listener;

import java.util.ArrayList;

public class EventManager {

    public static final ArrayList<Listener> LISTENERS = new ArrayList<>();
    private static ModuleManager moduleManager;

    public EventManager(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

}
