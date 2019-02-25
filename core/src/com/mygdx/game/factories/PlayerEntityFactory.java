package com.mygdx.game.factories;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Interface.AbstractEntityFactory;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.RenderComponent;
import com.mygdx.game.components.SizeComponent;
import com.mygdx.game.components.SpriteComponent;
import com.mygdx.game.engine.utils.EntityRenderOrder;
import com.mygdx.game.engine.utils.SpecialEntityID;
import com.mygdx.game.engine.utils.data.Screen;
import com.mygdx.game.entities.Player;
import com.mygdx.game.systems.UpdateSpriteSystem;
import com.mygdx.game.systems.game.MoveCharacterSystem;
import com.mygdx.game.systems.game.RenderSystem;

public class PlayerEntityFactory extends AbstractEntityFactory {

    private static PlayerEntityFactory player;
    private AssetManager assetManager;
    private SpriteBatch batch;

    public PlayerEntityFactory(AssetManager assetManager, SpriteBatch batch) {
        this.assetManager = assetManager;
        this.batch = batch;
    }

    public static PlayerEntityFactory getInstance(AssetManager assetManager, SpriteBatch batch) {
        if(player == null) {
            player = new PlayerEntityFactory(assetManager, batch);
        }

        return player;
    }

    @Override
    public void buildEntity() {
        id = SpecialEntityID.PLAYER_ENTITY;
        entity = new Player(id);
    }

    @Override
    public void buildComponentList() {
        Sprite sprite = new Sprite(new Texture("fisherman.png"));
        //Sprite sprite = new Sprite(assetManager.get("fisherman.png", Texture.class));
        componentList.add(new SpriteComponent(id, sprite));
        componentList.add(new RenderComponent(id, batch, EntityRenderOrder.getEntityRenderOrder()));
        componentList.add(new PositionComponent(id, Screen.SCREEN_WIDTH - 700, Screen.SCREEN_HEIGHT / 2));
        componentList.add(new SizeComponent(id, 750, 550));
    }

    @Override
    public void buildSystemList() {
        systemList.add(new RenderSystem(id));
        systemList.add(new UpdateSpriteSystem(id));
        systemList.add(new MoveCharacterSystem(id));
    }
}
