package Interface;

import java.util.HashMap;

public interface IEventListener {
    int getID();
    String getType();
    boolean canHandle(int id, String type);
    void handleEvent(HashMap<String, String> args);
}
