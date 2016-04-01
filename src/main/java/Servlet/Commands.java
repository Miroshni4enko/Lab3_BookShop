package Servlet;

import java.util.Map;

/**
 * Class that generate commands for servlet.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */
public class Commands {
    private Map<String, Object> map;

    protected static class Singleton {
        public static final Commands _INSTANCE = new Commands();
    }

    private Commands() {
        this.initMap();
    }

    public static Commands getInstance() {
        return Singleton._INSTANCE;
    }

    public Map<String, Object> getCommandsMap(){
        return map;
    }

    private void initMap() {
        map.put("cmd1", "new Cmd01()");
        map.put("cmd2", "new Cmd02()");
    }

}
