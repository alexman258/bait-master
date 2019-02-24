package com.mygdx.game.systems.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.mygdx.game.Interface.IEntity;
import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.components.RenderComponent;
import com.mygdx.game.components.SpriteComponent;
import com.mygdx.game.engine.ComponentManager;
import com.mygdx.game.engine.EntityManager;

public class RenderSystem implements ISystem {
    private int id;
    private String type;
    private ComponentManager componentManager;
    private EntityManager entityManager;

    public RenderSystem(int id){
        this.id = id;
        componentManager = componentManager.getInstance();
        entityManager = entityManager.getInstance();
        type = "RenderSystem";
    }

    @Override
    public int getID(){return id;}

    @Override
    public String getType(){return type;}

    @Override
    public void update(){
        RenderComponent renderComponent = (RenderComponent) componentManager.getComponent(id, "RenderComponent");

        SpriteBatch batch = renderComponent.getSpriteBatch();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        for(String type : renderComponent.getRenderOrder()) {
            HashMap<Integer, IEntity> entityMap = entityManager.getEntities(type);
            if(null != entityMap) {
                Set<Map.Entry<Integer,IEntity>> entities = entityMap.entrySet();
                for(Map.Entry<Integer,IEntity> e : entities) {
                    int id = e.getValue().getID();
                    SpriteComponent sp = (SpriteComponent)componentManager.getComponent(id, "SpriteComponent");
                    if(sp.isVisible()) {
                        sp.getSprite().draw(batch);
                    }
                }
            }
        }

        batch.end();
    }

}
