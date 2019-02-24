package com.mygdx.game.entities;

import com.badlogic.gdx.Game;
import com.mygdx.game.Interface.IEntity;

public class GameEntity implements IEntity {
    private int id;
    private String type;

    public GameEntity(int id){
        this.id = id;
        type = "Shore";
    }

    @Override
    public int getID(){return id;}

    @Override
    public String getType(){return type;}
}
