package com.mygdx.game.engine;

import java.util.ArrayList;

import com.mygdx.game.Interface.IEntity;
import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.Interface.IComponent;

public class Engine {
    private static Engine engine;
    private ComponentManager cm;
    private EntityManager em;

    private String[] systemUpdateOrder;
    private ArrayList<Integer> flaggedForRemoval;

    private Engine(String[] systemUpdateOrder) {
        this.systemUpdateOrder = systemUpdateOrder;
        cm = ComponentManager.getInstance();
        em = EntityManager.getInstance();
        flaggedForRemoval = new ArrayList<Integer>();
    }

    public static Engine getInstance(String[] systemUpdateOrder) {
        if (null == engine) {
            engine = new Engine(systemUpdateOrder);
        }
        return engine;
    }

    private void removeFlagged() {
        for (Integer id : flaggedForRemoval) {
            em.removeEntity(id);
        }
        flaggedForRemoval.clear();
    }

    public ComponentManager getComponentManager() {
        return cm;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public String[] getOrderedSystemTypes(){return systemUpdateOrder;}

    public int acquireEntityID(){return em.acquireEntityId();}

    public void addEntity(IEntity e, ArrayList<IComponent> cl, ArrayList<ISystem> sl){
        em.addEntity(e);
        for(IComponent c : cl){
            cm.addComponent(c);
        }
        for(ISystem s : sl){
            // Add system manager here
            //sm.addSystem(s);
        }
    }

    //TODO: Finish this function
    public void removeEntity(int id){
        em.removeEntity(id);
        //cm.removeComponent(id);
    }

    public void flagEntityForRemoval(int id){flaggedForRemoval.add(id);}

    public void update(){
        for(String sType : systemUpdateOrder){
          //  if(null != com.mygdx.game.systems){
            //    for
            //}
        }
    }
}