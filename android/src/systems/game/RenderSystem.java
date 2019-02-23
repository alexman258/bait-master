package systems.game;


import Interface.ISystem;

public class RenderSystem implements ISystem {
    private int id;
    private String type;

    public RenderSystem(int id){
        this.id = id;
    }

    @Override
    public int getID(){return id;}

    @Override
    public String getType(){return type;}

    @Override
    public void update(){}

}
