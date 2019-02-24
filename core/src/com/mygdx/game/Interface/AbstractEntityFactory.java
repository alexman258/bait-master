package com.mygdx.game.Interface;

import java.util.ArrayList;

public abstract class AbstractEntityFactory {

    protected int id;
    protected ArrayList<IComponent> componentList;
    protected ArrayList<ISystem> systemList;
    protected IEntity entity;

    public AbstractEntityFactory(int id) {
        this.id = id;
        componentList = new ArrayList<IComponent>();
        systemList = new ArrayList<ISystem>();
    }

    public abstract void buildEntity();
    public abstract void buildComponentList();
    public abstract void buildSystemList();

    public ArrayList<IComponent> getComponentList() {
        return componentList;
    }

    public ArrayList<ISystem> getSystemList() {
        return systemList;
    }

    public IEntity getEntity() {
        return entity;
    }

}
