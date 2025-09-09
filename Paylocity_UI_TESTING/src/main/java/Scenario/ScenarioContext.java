package Scenario;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final HashMap<String, Object> contextData = new HashMap<>();

    public Map<String, Object> get_Hashmap(){
        return contextData;
    }

    private ScenarioContext() {}
    private static final ScenarioContext INSTANCE = new ScenarioContext();

    public static ScenarioContext getInstance() {
        return INSTANCE;
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(contextData.get(key));
    }

    public void put(String key, Object value) {
        contextData.put(key, value);
    }

    public void remove(String key) {
        contextData.remove(key);
    }

    public void removeAll() {
        contextData.clear();
    }

    private static class SingletonHelper {
        private static final ScenarioContext INSTANCE = new ScenarioContext();
    }

    public static ScenarioContext getContext() {
        return SingletonHelper.INSTANCE;
    }
}