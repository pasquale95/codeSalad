package chapter03.ex3_1;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class StackOverflowException extends Exception {
    public StackOverflowException(String errorMessage) {
        super(errorMessage);
    }
}
