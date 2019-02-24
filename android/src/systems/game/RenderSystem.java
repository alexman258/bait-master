package systems.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Interface.IEntity;
import Interface.ISystem;
import components.RenderComponent;
import components.SpriteComponent;
import engine.ComponentManager;
import engine.EntityManager;

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
        RenderComponent renderComponent = (RenderComponent) componentManager.getComponent("RenderComponent");

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
                    SpriteComponent sp = (SpriteComponent)componentManager.getComponent(id);
                    if(sp.isVisible()) {
                        sp.getSprite().draw(batch);
                    }
                }
            }
        }
        batch.end();

    }

}
