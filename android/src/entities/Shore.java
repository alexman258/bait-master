package entities;

import Interface.IEntity;

public class Shore implements IEntity {


    private int id;
    private String type;

    public Shore(int id){
        this.id=id;
        type="Shore";

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
