package com.mygdx.game.Interface;

import java.util.HashMap;

public interface IEvent {
    int getID();
    String getType();
    HashMap<String, String> getArgs();
}
