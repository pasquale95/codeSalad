package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Configurator {

    private final JSONObject configs;

    public Configurator(Level level) throws IOException, ParseException {
        this.configs = parseConfig(level.getFilename());
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
