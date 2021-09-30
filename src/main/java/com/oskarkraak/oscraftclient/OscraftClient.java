package com.oskarkraak.oscraftclient;

import com.mojang.authlib.GameProfile;
import com.oskarkraak.oscraftclient.mixin.ClientPlayerEntityMixin;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OscraftClient implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("oscraft");
    public static int c = 0;

    @Override
    public void onInitialize() {
        // Mod starts here
        LOGGER.info("The Oscraft Client salutes you!");

        System.out.println("started");

        ModuleManager moduleManager = new ModuleManager();

        EventManager eventManager = new EventManager(moduleManager);

    }

}