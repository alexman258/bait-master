package com.mygdx.game.systems;

import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.SizeComponent;
import com.mygdx.game.components.SpriteComponent;
import com.mygdx.game.engine.ComponentManager;

public class UpdateSpriteSystem implements ISystem {
    private int id;
    private String type;
    private ComponentManager componentManager;

    public UpdateSpriteSystem(int id){
        this.id=id;
        type= "UpdateSpriteSystem";
        componentManager= ComponentManager.getInstance();
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
        SpriteComponent spriteComponent=(SpriteComponent)componentManager.getComponent(id, "SpriteComponent");
        PositionComponent locationComponent=(PositionComponent) componentManager.getComponent(id, "PositionComponent");
        SizeComponent sizeComponent=(SizeComponent)componentManager.getComponent(id, "SizeComponent");

        spriteComponent.getSprite().setCenter((float)locationComponent.getX(),(float)locationComponent.getY());
        spriteComponent.getSprite().setSize((float)sizeComponent.getWidth(), (float)sizeComponent.getHeight());

    }
}
