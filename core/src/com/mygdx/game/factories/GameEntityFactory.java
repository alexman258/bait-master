package com.mygdx.game.factories;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Interface.IComponent;
import com.mygdx.game.Interface.IEntity;
import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.components.AssetManagerComponent;
import com.mygdx.game.components.GameTimeComponent;
import com.mygdx.game.components.RenderComponent;
import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.utils.EntityRenderOrder;
import com.mygdx.game.engine.utils.SpecialEntityID;
import com.mygdx.game.engine.utils.SystemUpdateOrder;
import com.mygdx.game.entities.GameEntity;
import com.mygdx.game.systems.game.RenderSystem;
import com.mygdx.game.systems.game.SpawnerSystem;

import java.util.ArrayList;

public class GameEntityFactory {
    private static Engine engine = Engine.getInstance(SystemUpdateOrder.getSystemUpdateOrder());
    private static ArrayList<IComponent> cl = new ArrayList<IComponent>();
    private static ArrayList<ISystem> sl = new ArrayList<ISystem>();

    private static void create(SpriteBatch batch, AssetManager am){
        int id = SpecialEntityID.GAME_ENTITY;
        IEntity entity = new GameEntity(id);

    }

    private static void generateComponentList(int id, SpriteBatch batch, AssetManager am){
        cl.clear();
        cl.add(new RenderComponent(id, batch, EntityRenderOrder.getEntityRenderOrder()));
        cl.add(new AssetManagerComponent(id, am));
        cl.add(new GameTimeComponent(id));

    }

    private static void generateSystemList(int id){
        sl.clear();
        sl.add(new RenderSystem(id));
        sl.add(new SpawnerSystem(id));
    }
}
