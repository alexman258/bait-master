package entities;

import Interface.IEntity;


public class Player  implements IEntity {

    private int id;
    private String type;

    public Player(int id){
        this.id=id;
        type="Player";

    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

}
