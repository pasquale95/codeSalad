package chapter01.ex1_6;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class After implements Runnable {

    private final String[] originals;

    public After(String[] originals) {
        this.originals = originals;
    }

    @Override
    public void run() {
        for (String original : this.originals) {
            compress(original);
        }
    }

    /**
     * Complexity: O(n)
     *
     * @param   original The original string.
     * @return  The compressed string
     */
    public static String compress(String original) {
        int originalLength = original.length();
        int compressedLength = getCompressedLength(original);
        // if compression is useless, return original without going further with the algorithm
        if (compressedLength >= originalLength) {
            return original;
        }
        // if here, compression is worth: do it
        StringBuilder sb = new StringBuilder(compressedLength);
        int counter = 0;
        for (int i = 0; i < originalLength; i++) {
            counter++;
            if ((i+1) >= originalLength || original.charAt(i) != original.charAt(i+1)) {
                sb.append(original.charAt(i)).append(counter);
                counter = 0;
            }
        }
        return sb.toString();
    }

    /**
     * @param   original The original string.
     * @return  True if the compressed string is smaller than the original.
     */
    private static int getCompressedLength(String original) {
        int compressedLength = 0, originalLength = original.length();
        // count compressed string length
        if (originalLength > 0) {
            for (int i = 0; i < originalLength; i++) {
                if ((i+1) >= originalLength || original.charAt(i) != original.charAt(i+1)) {
                    compressedLength += 2;
                }
            }
        }
        return compressedLength;
    }
}
