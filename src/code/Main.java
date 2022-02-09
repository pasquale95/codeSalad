import chapter01.Chapter01;
import chapter02.Chapter02;
import chapter03.Chapter03;
import utils.architecture.ChapterTemplate;
import utils.architecture.ConfigManager;

import java.util.ArrayList;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Main {

    public static void main(String[] args) {
        try {
            ArrayList<ChapterTemplate> chapters = getChaptersList();
            ConfigManager configManager = ConfigManager.getInstance();
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
                timeSolutions(configManager, chapters);
            } else {
                runSolutions(configManager, chapters);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
    public static void runSolutions(ConfigManager configManager, ArrayList<ChapterTemplate> chapters) {
        runPreSolutions(configManager, chapters);
        runPostSolutions(configManager, chapters);
    }

    /**
     * Run pre solutions
     */
    public static void runPreSolutions(ConfigManager configManager, ArrayList<ChapterTemplate> chapters) {
        for (ChapterTemplate chapter : chapters) {
            chapter.runPreSolutions(configManager);
        }
    }

    /**
     * Run post solutions
     */
    public static void runPostSolutions(ConfigManager configManager, ArrayList<ChapterTemplate> chapters) {
        for (ChapterTemplate chapter : chapters) {
            chapter.runPostSolutions(configManager);
        }
    }

    /**
     * Time all solutions
     */
    public static void timeSolutions(ConfigManager configManager, ArrayList<ChapterTemplate> chapters) {
        for (ChapterTemplate chapter : chapters) {
            chapter.timeSolutions(configManager);
        }
    }
}
