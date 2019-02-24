package com.mygdx.game.engine;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void dispatchEvents(){
        for(IEvent event : events){
            if(event.getID()!=null){

            }
        }
    }
}
