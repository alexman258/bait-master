package engine;

import java.util.HashMap;
import java.util.Map;

import Interface.ISystem;

public class SystemManager {

    private static SystemManager systemManager;
    private HashMap<Integer, HashMap<String, ISystem>> systemIds;
    private HashMap<String, HashMap<Integer, ISystem>> systemTypes;

    private SystemManager() {
        systemIds = new HashMap<Integer, HashMap<String, ISystem>>();
        systemTypes = new HashMap<String, HashMap<Integer, ISystem>>();
    }

    public static SystemManager getInstance() {
        if(systemManager == null) {
            return new SystemManager();
        }

        return systemManager;
    }

    public void addSystem(ISystem system) {

        if(systemIds.containsKey(system.getID())) {
            systemIds.get(system.getID()).put(system.getType(), system);
        } else {
            systemIds.put(system.getID(), new HashMap<String, ISystem>());
            systemIds.get(system.getID()).put(system.getType(), system);
        }

        if(systemTypes.containsKey(system.getType())) {
            systemTypes.get(system.getType()).put(system.getID(), system);
        } else {
            systemTypes.put(system.getType(), new HashMap<Integer, ISystem>());
            systemTypes.get(system.getType()).put(system.getID(), system);
        }
    }

    public void removeSystems(int id) {

        HashMap<String, ISystem> systemToRemove = systemIds.remove(id);

        for(Map.Entry<String, ISystem> map : systemToRemove.entrySet()) {
            .get()
        }

    }

    public void removeSystem(String type) {

        int temp;

        if(systemTypes.containsKey(type)) {
            temp = systemTypes.get(type).getID();
            systemTypes.remove(type);
            removeSystem(temp);
        }
    }

    public void removeSystem(ISystem system) {

        if(systemIds.containsKey(system.getID())) {
            systemIds.get(system.getID()).remove(system.getType());
        }

        if(systemTypes.containsKey(system.getType())) {
            systemTypes.get(system.getType()).remove(system.getID());
        }
    }

    // GETTERS AND SETTERS

    public HashMap<Integer, ISystem> getSystem(int id) {
        return
    }

}
