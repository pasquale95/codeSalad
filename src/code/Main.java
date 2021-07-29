import org.json.simple.parser.ParseException;
import utils.Configurator;
import utils.Level;

import java.io.IOException;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Main {

    public static void main(String[] args) {
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
            timeSolutions();
        } else {
            runSolutions();
        }
    }

    /**
     * Run all solutions
     */
    public static void runSolutions() {
        chapter01.Main.runSolutions();
        chapter02.Main.runSolutions();
        chapter03.Main.runSolutions();
    }

    /**
     * Time all solutions
     */
    public static void timeSolutions() {
        try {
            Configurator configurator = new Configurator(Level.LOW);
            chapter01.Main.timeSolutions(configurator);
            chapter02.Main.timeSolutions(configurator);
            chapter03.Main.timeSolutions(configurator);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
