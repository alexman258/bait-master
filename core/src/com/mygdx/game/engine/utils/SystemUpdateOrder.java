package com.mygdx.game.engine.utils;

public class SystemUpdateOrder {

    private static String[] systemUpdateOrder = {"InputSystem","UpdateSpriteSystem","RenderSystem"};

    public static String[] getSystemUpdateOrder() {

        return systemUpdateOrder;
    }
}
