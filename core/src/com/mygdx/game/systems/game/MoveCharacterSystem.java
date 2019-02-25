package com.mygdx.game.systems.game;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.SpriteComponent;
import com.mygdx.game.engine.ComponentManager;
import com.mygdx.game.engine.EntityManager;
import com.mygdx.game.engine.utils.data.Screen;
import com.mygdx.game.entities.Player;

public class MoveCharacterSystem implements ISystem {

    private int id;
    private int y;
    private String type;
    private ComponentManager componentManager;
    private EntityManager entityManager;

    public MoveCharacterSystem(int id) {
        this.id = id;
        type = "MoveCharacterSystem";
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
        PositionComponent positionComponent = (PositionComponent) componentManager.getComponent(id, "PositionComponent");
        SpriteComponent spriteComponent = (SpriteComponent) componentManager.getComponent(id, "SpriteComponent");
        checkMove();
    }

    private void checkMove() {

        if(Gdx.input.justTouched()) {

            Player player = (Player) entityManager.getEntity(id);

            double y = Gdx.input.getY();
            double change = (Screen.SCREEN_HEIGHT / 2) - y;

            if(player != null && player.isSelected()) {
                PositionComponent positionComponent = (PositionComponent) componentManager.getComponent(0, "PositionComponent");
                positionComponent.setY(change - Screen.SCREEN_HEIGHT / 2);
                player.setSelection(false);
            } else if (player != null && !player.isSelected()) {
                player.setSelection(true);
            }
        }
    }
}
