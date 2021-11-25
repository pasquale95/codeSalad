package utils.architecture;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public enum Level {
    LOW("timingStress/low.json"),
    MEDIUM("timingStress/medium.json"),
    HIGH("timingStress/high.json");

    private final String filename;

    Level(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }
}