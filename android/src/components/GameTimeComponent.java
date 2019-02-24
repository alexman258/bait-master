package components;

import Interface.IComponent;

public class GameTimeComponent implements IComponent {

    private int id;
    private String type;
    private long time;

    public GameTimeComponent(int id) {
        this.id = id;
        type = "GameTimeComponent";
        time = System.nanoTime() / 1000000000;
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

    public long getTime() {
        return time;
    }

}
