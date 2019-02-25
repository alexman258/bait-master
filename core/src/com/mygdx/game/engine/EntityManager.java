package com.mygdx.game.engine;


import java.util.HashMap;
import java.util.Map;

import com.mygdx.game.Interface.IEntity;

public class EntityManager {
    private static EntityManager em;

    private int nextId;
    private HashMap<Integer, IEntity> entities;
    private HashMap<String, HashMap<Integer, IEntity>> entityTypePools;


    private EntityManager(){
        nextId=0;
        entities= new HashMap<Integer, IEntity>();
        entityTypePools= new HashMap<String, HashMap<Integer, IEntity>>();
    }

    /*
    Singleton getter
     */
    public static EntityManager getInstance(){
        if (em==null){
            em=new EntityManager();
        }
        return em;
    }


    public HashMap<Integer, IEntity> getEntities(String type) {
        return entityTypePools.get(type);
    }

    public IEntity getEntity(int id) {
        return entities.get(id);
    }

    /*
    Get the next available id to be used for com.mygdx.game.entities
    */

    public int acquireEntityId() {
        return nextId++;
    }

    /*
    Add com.mygdx.game.entities to the entityTypePool variable
     */
    public void addEntity(IEntity e){
        entities.put(e.getID(),e);
        String type =e.getType();
        int id = e.getID();

        if(entityTypePools.containsKey(type)){
            entityTypePools.get(type).put(id, e);
        }
        else{
            entityTypePools.put(type,new HashMap<Integer, IEntity>());
            entityTypePools.get(e.getType()).put(id, e);
        }
    }

    /*
    Removes the entity from the entityTypePool variable
     */
    public void removeEntities(String type){
        HashMap<Integer,IEntity> removedEntities = entityTypePools.remove(type);

        if(removedEntities!=null){
            for (Map.Entry<Integer, IEntity> e : removedEntities.entrySet()){
                entities.remove(e.getValue().getID());
            }
        }
    }

    /*
    Remove an entity of a given id
     */
    public void removeEntity(int id){
        if(entities.containsKey(id)){
            IEntity e = entities.remove(id);
            entityTypePools.get(e.getType()).remove(id);
        }
    }

    /*
   Remove an entity of a given entity
    */
    public void removeEntity(IEntity e){
        if(entities.containsKey(e.getID())){
            entityTypePools.get(e.getType()).remove(e);
            entities.remove(e.getID());
        }
    }
}

