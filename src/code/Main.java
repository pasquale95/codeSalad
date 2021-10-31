import chapter01.Chapter01;
import chapter02.Chapter02;
import chapter03.Chapter03;
import org.json.simple.parser.ParseException;
import utils.ChapterTemplate;
import utils.ConfigManager;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<ChapterTemplate> chapters = getChaptersList();
        boolean timing = false;
        // home-made options parser in order to not require any 3rd party java package
        if (args.length > 0) {
            for (String arg : args) {
                if ("-t".equals(arg)) {
                    timing = true;
                    break;
                }
            }
        }
        // run solutions
        //timeSolutions();
        if (timing) {
            timeSolutions(chapters);
        } else {
            runSolutions(chapters);
        }
    }

    protected static ArrayList<ChapterTemplate> getChaptersList() {
        ArrayList<ChapterTemplate> chapters = new ArrayList<>();
        chapters.add(new Chapter01());
        chapters.add(new Chapter02());
        chapters.add(new Chapter03());
        return chapters;
    }

    /**
     * Run all solutions
     */
    public static void runSolutions(ArrayList<ChapterTemplate> chapters) {
        for (ChapterTemplate chapter : chapters) {
            chapter.runSolutions();
        }
    }

    /**
     * Time all solutions
     */
    public static void timeSolutions(ArrayList<ChapterTemplate> chapters) {
        try {
            ConfigManager configManager = ConfigManager.getInstance();
            for (ChapterTemplate chapter : chapters) {
                chapter.timeSolutions(configManager);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
