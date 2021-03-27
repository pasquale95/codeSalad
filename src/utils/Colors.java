package utils;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Colors {
    public static final boolean ENABLE_COLORS = true;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void printBlue(String string) {
        System.out.println(colorBlue(string));
    }

    public static void printRed(String string) {
        System.out.println(colorRed(string));
    }

    public static void printGreen(String string) {
        System.out.println(colorGreen(string));
    }

    public static void printYellow(String string) {
        System.out.println(colorYellow(string));
    }

    public static String colorBlue(String string) {
        if (ENABLE_COLORS) {
            string = ANSI_BLUE + string + ANSI_RESET;
        }
        return string;
    }

    public static String colorRed(String string) {
        if (ENABLE_COLORS) {
            string = ANSI_RED + string + ANSI_RESET;
        }
        return string;
    }

    public static String colorGreen(String string) {
        if (ENABLE_COLORS) {
            string = ANSI_GREEN + string + ANSI_RESET;
        }
        return string;
    }

    public static String colorYellow(String string) {
        if (ENABLE_COLORS) {
            string = ANSI_YELLOW + string + ANSI_RESET;
        }
        return string;
    }
}
