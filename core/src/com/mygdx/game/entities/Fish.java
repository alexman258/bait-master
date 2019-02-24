package com.mygdx.game.entities;

import com.mygdx.game.Interface.IEntity;

public class Fish implements IEntity {

    private int id;
    private String type;

    public Fish(int id){
        this.id=id;
        type="Fish";

    }
    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }
}
