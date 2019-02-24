package components;

import Interface.IComponent;

public class VelocityComponent implements IComponent {

    private int id;
    private String type;
    private double baseSpeed;
    private double x, y;

    public VelocityComponent(int id, double baseSpeed) {
        this.id = id;
        this.baseSpeed = baseSpeed;
        type = "VelocityComponent";
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

    public double getBaseSpeed() {
        return baseSpeed;
    }

    public void setDouble(double baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
