package com.mygdx.game.systems.game;

import com.mygdx.game.Interface.ISystem;

public class SpawnerSystem implements ISystem {
    private int id;
    private String type;

    public SpawnerSystem(int id){
        this.id =id;
        type = "SpawnerSystem";
    }

    @Override
    public int getID(){return id;}

    @Override
    public String getType(){return type;}

    @Override
    public void update(){}

    private void spawnFish(){}
}
