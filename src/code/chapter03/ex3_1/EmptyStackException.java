package chapter03.ex3_1;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class EmptyStackException extends Exception {
    public EmptyStackException(String errorMessage) {
        super(errorMessage);
    }
}
