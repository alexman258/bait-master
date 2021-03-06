package com.mygdx.game.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.Interface.IComponent;

public class RenderComponent implements IComponent {

    private int id;
    private String type;
    private SpriteBatch batch;
    private String[] renderOrder;

    public RenderComponent(int id, SpriteBatch batch, String[] renderOrder) {
        this.id = id;
        this.batch = batch;
        this.renderOrder = renderOrder;
        type = "RenderComponent";
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    // GETTERS AND SETTERs

    public SpriteBatch getSpriteBatch() {
        return batch;
    }

    public String[] getRenderOrder() {
        return renderOrder;
    }
}
