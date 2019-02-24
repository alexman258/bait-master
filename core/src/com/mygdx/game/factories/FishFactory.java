package com.mygdx.game.factories;

import android.content.res.AssetManager;

import java.util.ArrayList;

import com.mygdx.game.Interface.IComponent;
import com.mygdx.game.Interface.IEntity;
import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.engine.Engine;
import com.mygdx.game.entities.Fish;
import com.mygdx.game.systems.MovementSystem;
import com.mygdx.game.engine.utils.SystemUpdateOrder;
import com.mygdx.game.engine.utils.data.FishData;

public class FishFactory {
    private static Engine engine = Engine.getInstance(SystemUpdateOrder.getSystemUpdateOrder());
    private static ArrayList<IComponent> cl = new ArrayList<>();
    private static ArrayList<ISystem> sl = new ArrayList<>();

    public static void create(AssetManager assetManager, FishData fishdata){
        int id = engine.acquireEntityID();
        IEntity entity = new Fish(id);
        generateComponentList(id, assetManager, fishdata);
        generateSystemList(id);
        engine.addEntity(entity, cl, sl);
    }

    private static void generateComponentList(int id, AssetManager assetManager, FishData fishData){
        //STUB
        //TODO: Add all com.mygdx.game.components
        cl.clear();
        //cl.add(new SpriteComponent(id, fishSprite));
        //cl.add(new SizeComponent(id));
    }

    private static void generateSystemList(int id){
        sl.clear();
        sl.add(new MovementSystem(id));
        //TODO: The rest of the com.mygdx.game.systems
    }
}
