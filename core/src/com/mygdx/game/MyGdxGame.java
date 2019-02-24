package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.Interface.IComponent;
import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.RenderComponent;
import com.mygdx.game.components.SpriteComponent;
import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.utils.EntityRenderOrder;
import com.mygdx.game.engine.utils.SystemUpdateOrder;
import com.mygdx.game.entities.Fish;
import com.mygdx.game.systems.game.RenderSystem;


import java.awt.Image;
import java.util.ArrayList;

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
		engine = Engine.getInstance(SystemUpdateOrder.getSystemUpdateOrder());
		testSpawn();
	}

	@Override
	public void render () {
		if(engine != null) {
			engine.update();
		}

	}

	@Override
	public void dispose () {
		batch.dispose();
		assetManager.dispose();
	}

	private void testSpawn() {
		Fish fisha = new Fish(0);
		ArrayList<IComponent> cl = new ArrayList<IComponent>();
		ArrayList<ISystem> sl = new ArrayList<ISystem>();

		cl.add(new PositionComponent(fisha.getID(), 0,0));
		cl.add(new RenderComponent(fisha.getID(), batch, EntityRenderOrder.getEntityRenderOrder()));
		cl.add(new SpriteComponent(fisha.getID(), new Sprite(new Texture("fisha.png"))));
		sl.add(new RenderSystem(fisha.getID()));

		engine.addEntity(fisha, cl, sl);
	}

	private void loadAssets() {

		assetManager.load("shore.png", Texture.class);
		assetManager.load("fisha.png", Texture.class);
	}
}