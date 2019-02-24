package com.mygdx.game.entities;

import com.mygdx.game.Interface.IEntity;

public class Projectile implements IEntity {

    private int id;
    private String type;

    public Projectile(int id){
        this.id=id;
        type="Projectile";

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
