package com.mygdx.game.components;

import android.content.res.AssetManager;

import com.mygdx.game.Interface.IComponent;

public class AssetManagerComponent implements IComponent {

    private int id;
    private String type;
    private AssetManager assetManager;

    public AssetManagerComponent(int id, AssetManager assetManager) {
        this.id = id;
        this.assetManager = assetManager;
        type = "AssetManagerComponent";
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    // GETTERS AND SETTERS

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
