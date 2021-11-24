package utils.exceptions;

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
