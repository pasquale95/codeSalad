package utils.architecture;

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