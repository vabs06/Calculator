import exception.InputException;
import exception.NegativeNumberException;

import java.util.ArrayList;

public class StringCalculator {
    public static int addCallCount = 0;

    public static final String delimit = ",";
    public static final String newLine = "\n";
    public static final String INVALID = "INVALID Input.";
    public static final String UN_AMOUNT = "Unknown Amount of Numbers.";
    public static final String NEG_NA = "Negatives not allowed.";

    ArrayList<Integer> negativeList;

    public StringCalculator() {
//        addCallCount = 0;
        negativeList = new ArrayList<>();
    }


    public int Add(String numbers) {
        addCallCount++;
        int result = 0;

        if (numbers.length() == 0) {
            return 0;
        }

        if (numbers.length() == 1 && Character.getNumericValue(numbers.charAt(0)) < 0) {
            throw new NegativeNumberException(NEG_NA);
        }

        if (numbers.length() == 1) {
            return Character.getNumericValue(numbers.charAt(0));
        }

        int idx = numbers.indexOf(newLine);
        if (idx > 0 && numbers.charAt(idx - 1) == ',') {
            throw new InputException(INVALID);
        }

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
            throw new InputException(UN_AMOUNT);
        }

        for(String s: input) {
            int number = Integer.parseInt(s);

            if (number < 0) {
                for (String value : input) {
                    int no = Integer.parseInt(value);
                    if (no < 0)
                        negativeList.add(no);
                }
                String custom = NEG_NA + " " + negativeList.toString();
                throw new NegativeNumberException(custom);
            }

            if(number < 1001 && number > -1)
                result += number;
        }

        return result;
    }

    public int GetCalledCount() {
        return addCallCount;
    }
}
