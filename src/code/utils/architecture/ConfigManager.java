package utils.architecture;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ConfigManager {
    private final JSONObject configs;
    private static ConfigManager instance;

    /**
     * ConfigManager constructor implementing Singleton design pattern.
     * @param   level The stress level
     * @throws  IOException If the config file is not found.
     * @throws  ParseException If the config file has a bad format.
     */
    private ConfigManager(Level level) throws IOException, ParseException {
        this.configs = parseConfig(level.getFilename());
    }

    /**
     * @return The existing configManager object. If none exist, create a new one and return it.
     */
    public static ConfigManager getInstance() throws IOException, ParseException {
        if (instance == null) {
            instance = new ConfigManager(Level.HIGH);
        }
        return instance;
    }

    private JSONObject parseConfig(String filename) throws IOException, ParseException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(new InputStreamReader(
                Objects.requireNonNull(classLoader.getResourceAsStream(filename))
        ));
    }

    public JSONObject getConfig(String chapterCode, String exerciseCode) {
        return (JSONObject) ((JSONObject) this.configs.get(chapterCode)).get(exerciseCode);
    }
}
