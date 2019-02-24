package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.utils.SystemUpdateOrder;


import java.awt.Image;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private AssetManager assetManager;
	private Engine engine;
	private Texture image;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		assetManager = new AssetManager();
		loadAssets();
		Engine.getInstance(SystemUpdateOrder.getSystemUpdateOrder());
	}

	@Override
	public void render () {
		engine.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assetManager.dispose();
	}

	private void loadAssets() {

		assetManager.load("shore.png", Texture.class);
		assetManager.load("fisha.png", Texture.class);
	}
}
