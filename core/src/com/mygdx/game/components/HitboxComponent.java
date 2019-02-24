package com.mygdx.game.components;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.compression.ICodeProgress;
import com.mygdx.game.Interface.IComponent;

public class HitboxComponent implements IComponent {
    private int id;
    private String type;
    private Rectangle hitbox;

    public HitboxComponent(int id, Rectangle hitbox){
        this.id = id;
        this.hitbox = hitbox;
        type = "HitboxComponent";
    }

    @Override
    public int getID(){return id;}

    @Override
    public String getType() {return type;}

    public Rectangle getHitbox(){return hitbox;}

    public void setHitbox(Rectangle hitbox){hitbox = hitbox;}
}
