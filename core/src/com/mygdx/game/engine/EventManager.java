package com.mygdx.game.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mygdx.game.Interface.IEvent;
import com.mygdx.game.Interface.IEventListener;

public class EventManager {

    private static EventManager eventManager;

    private ArrayList<IEvent> events;
    private HashMap<Integer, HashMap<String, IEventListener>> eventListenerIds;
    private HashMap<String, HashMap<Integer, IEventListener>> eventListenerTypes;

    private EventManager(){
        events= new ArrayList<IEvent>();
        eventListenerIds= new HashMap<Integer, HashMap<String, IEventListener>>();
        eventListenerTypes = new HashMap<String, HashMap<Integer, IEventListener>>();
    }

    public static EventManager GetInstance(){
        if (eventManager== null){
        eventManager=new EventManager();
        }
        return eventManager;
    }

    public void addEvent(IEvent event){
        events.add(event);
    }

    public void addEventListener(IEventListener eventListener){
        if(eventListenerIds.containsKey(eventListener.getID())){
            if(eventListenerIds.containsKey(eventListener.getID())){
                eventListenerIds.get(eventListener.getID()).put(eventListener.getType(),eventListener);
            }
            else {
                eventListenerIds.put(eventListener.getID(), new HashMap<String, IEventListener>());
                eventListenerIds.get(eventListener.getID()).put(eventListener.getType(), eventListener);
            }
        }
        else if (eventListener.getType()!= null){
            if(eventListenerTypes.containsKey(eventListener.getType())){
                eventListenerTypes.get(eventListener.getType()).put(eventListener.getID(),eventListener);
            }
            else {
                eventListenerTypes.put(eventListener.getType(), new HashMap<Integer, IEventListener>());
                eventListenerTypes.get(eventListener.getType()).put(eventListener.getID(), eventListener);
            }
        }
    }

    public void dispatchEvents() {
        for (IEvent event : events) {
            Integer id = event.getID();
            String type = event.getType();

            if (id != null) {
                HashMap<String, IEventListener> eventListenerHashMap = eventListenerIds.get(id);
                for (Map.Entry<String, IEventListener> entry : eventListenerHashMap.entrySet()) {
                    IEventListener eventListener = entry.getValue();
                    if (eventListener.canHandle(id, type)) {
                        eventListener.handleEvent(event.getArgs());
                    }
                }
            } else if (null != type) {
                HashMap<Integer, IEventListener> eventListenerHashMap = eventListenerTypes.get(type);
                for (Map.Entry<Integer, IEventListener> entry : eventListenerHashMap.entrySet()) {
                    IEventListener eventListener = entry.getValue();
                    if (eventListener.canHandle(id, type)) {
                        eventListener.handleEvent(event.getArgs());
                    }
                }
            }
        }
        events.clear();
    }

    public void removeEventListeners(int id) {
        HashMap<String, IEventListener> flaggedForRemoval = eventListenerIds.remove(id);
        for(Map.Entry<String, IEventListener> entry : flaggedForRemoval.entrySet()) {
            String type = entry.getValue().getType();
            if(null != type) {
                eventListenerTypes.get(type).remove(id);
            }
        }
    }


    public void removeEventListeners(String type) {

        HashMap<Integer, IEventListener> flaggedForRemoval = eventListenerTypes.remove(type);
        for(Map.Entry<Integer, IEventListener> entry : flaggedForRemoval.entrySet()) {
            Integer id = entry.getValue().getID();
            if(null != id) {
                eventListenerTypes.get(type).remove(id);
            }
        }

    }

    public void removeEventListener(int id, String type) {
        eventListenerIds.get(id).remove(type);
        eventListenerTypes.get(type).remove(id);
    }

}
