package com.mygdx.game.systems.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.engine.ComponentManager;
import com.mygdx.game.engine.EntityManager;
import com.mygdx.game.engine.utils.data.Screen;
import com.mygdx.game.systems.UpdateSpriteSystem;

public class InputSystem implements ISystem {

    private int id;
    private String type;
    private ComponentManager componentManager;
    private EntityManager entityManager;
    private Vector3 touchCoordinates;

    public InputSystem(int id) {
        this.id = id;
        type = "InputSystem";
        componentManager = ComponentManager.getInstance();
        entityManager = EntityManager.getInstance();
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getType() {

        return type;
    }

    @Override
    public void update() {
        justTouched();
    }

    private void justTouched() {
        if(Gdx.input.justTouched()) {
            PositionComponent positionComponent = (PositionComponent) componentManager.getComponent(0, "PositionComponent");

            double x = Gdx.input.getX();
            double y = Gdx.input.getY();

            double change = (Screen.SCREEN_HEIGHT / 2) - y;

            positionComponent.setX(x);
            positionComponent.setY(change - Screen.SCREEN_HEIGHT / 2);
        }
    }

    private void spawnFish() {

    }
}
