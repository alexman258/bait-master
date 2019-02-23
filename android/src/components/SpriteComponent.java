package components;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteComponent implements IComponent {

    private int id;
    private String type;
    private Sprite sprite;
    private boolean isVisible;

    public SpriteComponent(int id, Sprite sprite) {
        this.id = id;
        this.sprite = sprite;
        type = "SpriteComponent";
        isVisible = true;
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

    public Sprite getSprite() {
        return sprite;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
}
