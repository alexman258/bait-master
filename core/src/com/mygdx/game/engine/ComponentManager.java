package com.mygdx.game.engine;

import java.util.HashMap;
import java.util.Map;

import com.mygdx.game.Interface.IComponent;

public class ComponentManager {

    private static ComponentManager componentManager;
    private HashMap<Integer, HashMap<String, IComponent>> componentIds;
    private HashMap<String, HashMap<Integer, IComponent>> componentTypes;

    private ComponentManager() {
        componentTypes = new HashMap<String, HashMap<Integer, IComponent>>();
        componentIds = new HashMap<Integer, HashMap<String, IComponent>>();
    }

    public static ComponentManager getInstance() {
        if(componentManager == null) {
            return new ComponentManager();
        }

        return componentManager;
    }

    public void addComponent(IComponent component) {
        int id = component.getID();
        String type= component.getType();

        if(componentTypes.containsKey(component.getType())) {
            componentTypes.get(component.getType()).put(component.getID(), component);
        }
        else{
            componentTypes.put(component.getType(), new HashMap<Integer, IComponent>());
            componentTypes.get(component.getType()).put(component.getID(), component);
        }
        if(componentIds.containsKey(component.getID())) {
            componentIds.get(component.getID()).put(component.getType(),component);
        }
        else{
            componentIds.put(component.getID(), new HashMap<String, IComponent>());
            componentIds.get(component.getID()).put(component.getType(),component);

        }
    }


    public void removeComponents(int id) {
        HashMap<String, IComponent> flaggedForRemoval = componentIds.remove(id);
        if(flaggedForRemoval==null) {
            return;
        }
        for (Map.Entry<String,IComponent> e : flaggedForRemoval.entrySet()) {
            componentTypes.get(e.getValue().getType()).remove(id);
        }
    }

    public void removeComponent(int id, String type) {
            componentIds.get(id).remove(type);
            componentTypes.get(type).remove(id);
    }

    public void removeComponent(IComponent component) {

        if(componentIds.containsKey(component.getID())){
            componentIds.get(component.getID()).remove(component.getType());
        }
        if(componentTypes.containsKey(component.getType())){
            componentTypes.get(component.getType()).remove(component.getID());
        }
    }

    //Getters for a hashmap of all the entities
    public HashMap<String, IComponent> getComponents(int id) {

        return componentIds.get(id);
    }

    public HashMap<Integer, IComponent> getComponents(String type) {
        return componentTypes.get(type);
    }

    public IComponent getComponent(int id, String type) {
        return componentIds.get(id).get(type);
    }
}
