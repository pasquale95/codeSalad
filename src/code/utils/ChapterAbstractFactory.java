package utils;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public interface ChapterAbstractFactory {

    /**
     * Run all implemented solutions for the chapter.
     */
    void runSolutions();

    /**
     * Time all implemented solutions for the chapter.
     * @param   configManager The configManager.
     */
    void timeSolutions(ConfigManager configManager);
}
