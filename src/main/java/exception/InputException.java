package exception;

import java.util.InputMismatchException;

public class InputException extends InputMismatchException {

    public InputException(String message) {
        super(message);
    }

}
