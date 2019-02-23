package components;

public class PositionComponent implements IComponent {

    private int id;
    private double x, y;
    private String type;

    public PositionComponent(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        type = "PositionComponent";
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
