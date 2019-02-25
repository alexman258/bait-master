package com.mygdx.game.systems;

import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.SizeComponent;
import com.mygdx.game.components.SpriteComponent;
import com.mygdx.game.engine.ComponentManager;
import com.mygdx.game.engine.utils.data.Screen;

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
        PositionComponent positionComponent =(PositionComponent) componentManager.getComponent(id, "PositionComponent");

        if(componentManager.hasComponent(id, "SizeComponent")) {
            SizeComponent sizeComponent = (SizeComponent)componentManager.getComponent(id, "SizeComponent");
            spriteComponent.getSprite().setSize((float) sizeComponent.getWidth(), (float) sizeComponent.getHeight());
        }

        float x = (float) positionComponent.getX();
        float y = (float) positionComponent.getY();

        spriteComponent.getSprite().setCenter(x, y);
        //spriteComponent.getSprite().setSize((float)sizeComponent.getWidth(), (float)sizeComponent.getHeight());
    }
}
