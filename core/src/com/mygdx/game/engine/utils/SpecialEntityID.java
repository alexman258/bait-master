package com.mygdx.game.engine.utils;

public class SpecialEntityID {
    public static final int GAME_ENTITY = -1;
    public static final int PLAYER_ENTITY = -2;

    @Deprecated
    public static int getGameEntityID(){return GAME_ENTITY;}

    @Deprecated
    public static int getPlayerEntityID(){return PLAYER_ENTITY;}

}
