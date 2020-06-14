import exception.InputException;

import java.util.Collections;
import java.util.InputMismatchException;

public class StringCalculator {
    public static final String delimit = ",";
    public static final String newLine = "\n";

    public int Add(String numbers) {
        int result = 0;

        if (numbers.length() == 0) {
            return 0;
        }

        if(numbers.length() == 1) {
            return Character.getNumericValue(numbers.charAt(0));
        }

        int idx = numbers.indexOf(newLine);
        if(idx > 0 && numbers.charAt(idx - 1) == ',')
            throw new InputException("INVALID Input.");

        String []delimiter;
        String[] input;
        int lastIdx;
        if(numbers.startsWith("//")) {
            idx = numbers.indexOf(newLine);
            String tmp = numbers.substring(2, idx);

            if(tmp.length() != 1) {

                numbers = numbers.substring(idx + 1);

                tmp = tmp.replace("[", "")
                        .replace("]", delimit);

                lastIdx = tmp.lastIndexOf(delimit);
                delimiter = tmp.substring(0, lastIdx).split(delimit);


            } else {
                delimiter = new String[1];
                delimiter[0] = tmp;
                numbers = numbers.substring(idx + 1);

            }


            for(String d: delimiter) {
                numbers = numbers.replace(d, delimit);
            }


            input = numbers.split(delimit);


        } else {
            numbers = numbers.replace(newLine, delimit);
            input = numbers.split(delimit);
        }


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
