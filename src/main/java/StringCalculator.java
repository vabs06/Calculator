import exception.InputException;

import java.util.InputMismatchException;

public class StringCalculator {
    public int Add(String numbers) {
        int result = 0;

        if (numbers.length() == 0) {
            return 0;
        }

        if(numbers.length() == 1) {
            return Character.getNumericValue(numbers.charAt(0));
        }

        String[] input = numbers.split(",");

        if(input.length > 3){
            throw new InputException("Unknown Amount of Numbers.");
        }

        for(String s: input) {
            //  add a check any element is negative or not.
            result += Integer.parseInt(s);
        }

        return result;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
//        stringCalculator.Add("")
    }
}
