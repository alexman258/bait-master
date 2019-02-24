package engine;

import java.util.HashMap;

import Interface.IComponent;

public class ComponentManager {

    private static ComponentManager componentManager;
    private HashMap<String, IComponent> componentTypes;
    private HashMap<Integer, IComponent> componentIds;

    private ComponentManager() {
        componentTypes = new HashMap<String, IComponent>();
        componentIds = new HashMap<Integer, IComponent>();
    }

    public static ComponentManager getInstance() {
        if(componentManager == null) {
            return new ComponentManager();
        }

        return componentManager;
    }

    public void addComponent(IComponent component) {

        if(!componentTypes.containsKey(component.getType())) {
            componentTypes.put(component.getType(), component);
        }

        if(!componentIds.containsKey(component.getID())) {
            componentIds.put(component.getID(), component);
        }
    }

    public void removeComponent(int id, String type) {

        if(componentIds.containsKey(id)) {
            componentIds.remove(id);
        }

        if(componentTypes.containsKey(type)) {
            componentTypes.remove(type);
        }
    }

    public void removeComponent(IComponent component) {

        if(componentIds.containsKey(component.getID())) {
            componentIds.remove(component.getID());
        }

        if(componentTypes.containsKey(component.getType())) {
            componentTypes.containsKey(component.getType());
        }
    }

    // GETTERS AND SETTERS

    public HashMap<Integer, IComponent> getComponentIds() {
        return componentIds;
    }

    public HashMap<String, IComponent> getComponentTypes() {
        return componentTypes;
    }

    public IComponent getComponent(int id) {
        return componentIds.get(id);
    }

    public IComponent getComponent(String type) {
        return componentTypes.get(type);
    }

}
