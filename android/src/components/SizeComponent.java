package components;

import Interface.IComponent;

public class SizeComponent implements IComponent {

    private int id;
    private String type;
    private double width, height;

    public SizeComponent(int id, double width, double height) {
        this.id = id;
        this.width = width;
        this.height = height;
        type = "SizeComponent";
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

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


}
