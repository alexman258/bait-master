package systems;

import Interface.ISystem;

public class MovementSystem implements ISystem {
    private int id;
    private String type;

    public MovementSystem(int id){
        this.id = id;
        type = "MovementSystem";
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update() {

    }
}
