package com.oskarkraak.oscraftclient;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OscraftClient implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("oscraft");

    @Override
    public void onInitialize() {
        // Mod starts here
        LOGGER.info("The Oscraft Client salutes you!");

        System.out.println("started");

        ModuleManager moduleManager = new ModuleManager();

        EventManager eventManager = new EventManager(moduleManager);

    }

}