package exception;

import java.util.InputMismatchException;

public class InputException extends InputMismatchException {

    public InputException(String str) {
        super(str);
    }

}
