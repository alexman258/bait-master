package com.mygdx.game.systems.game;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.engine.ComponentManager;
import com.mygdx.game.engine.EntityManager;

public class InputSystem implements ISystem {

    private int id;
    private String type;
    private ComponentManager componentManager;
    private EntityManager entityManager;

    public InputSystem(int id) {
        this.id = id;
        type = "InputSystem";
        componentManager = ComponentManager.getInstance();
        entityManager = EntityManager.getInstance();
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void update() {

    }

    private void spawnFish() {
        double x = Gdx.input.
    }
}
