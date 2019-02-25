package com.mygdx.game.engine.utils;

public class SystemUpdateOrder {

    private static String[] systemUpdateOrder = {"InputSystem", "MoveCharacterSystem","UpdateSpriteSystem","RenderSystem"};

    public static String[] getSystemUpdateOrder() {

        return systemUpdateOrder;
    }
}
