package components;

public class ScoreComponent implements IComponent {

    private int id;
    private int score;
    private String type;

    public ScoreComponent(int id) {
        this.id = id;
        score = 0;
        type = "ScoreComponent";
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
