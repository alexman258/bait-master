package com.mygdx.game.factories;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Interface.AbstractEntityFactory;
import com.mygdx.game.Interface.IComponent;
import com.mygdx.game.Interface.IEntity;
import com.mygdx.game.Interface.ISystem;
import com.mygdx.game.components.AssetManagerComponent;
import com.mygdx.game.components.GameTimeComponent;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.RenderComponent;
import com.mygdx.game.components.SpriteComponent;
import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.utils.EntityRenderOrder;
import com.mygdx.game.engine.utils.SpecialEntityID;
import com.mygdx.game.engine.utils.SystemUpdateOrder;
import com.mygdx.game.entities.GameEntity;
import com.mygdx.game.systems.game.InputSystem;
import com.mygdx.game.systems.game.RenderSystem;
import com.mygdx.game.systems.game.SpawnerSystem;

import java.util.ArrayList;

public class GameEntityFactory extends AbstractEntityFactory {

    private AssetManager assetManager;
    private SpriteBatch spriteBatch;

    public GameEntityFactory(AssetManager assetManager, SpriteBatch spriteBatch, int id) {
        super(id);
        this.assetManager = assetManager;
        this.spriteBatch = spriteBatch;
    }

    @Override
    public void buildEntity() {
        entity = new GameEntity(SpecialEntityID.GAME_ENTITY);
    }

    @Override
    public void buildComponentList() {

        componentList.add(new SpriteComponent(SpecialEntityID.BACKGROUND_ENTITY,
                new Sprite(new Texture("shore.png"))));
        componentList.add(new PositionComponent(SpecialEntityID.BACKGROUND_ENTITY, 0, 0));
        componentList.add(new RenderComponent(id, spriteBatch, EntityRenderOrder.getEntityRenderOrder()));
        componentList.add(new AssetManagerComponent(id, assetManager));
    }

    @Override
    public void buildSystemList() {
        systemList.add(new RenderSystem(id));
        systemList.add(new InputSystem(id));
    }
}
