package io.github.algoram.infium;

import net.fabricmc.api.ModInitializer;

public class Infium implements ModInitializer {

    public static final String modId = "infium";

    @Override
    public void onInitialize() {
        InitializerClass.initialize();
    }
}
