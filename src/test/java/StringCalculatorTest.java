import static org.junit.Assert.*;

import exception.InputException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

    StringCalculator stringCalculator;
//    Exception exception;

    @Before
    public void getNewInstance() {
        stringCalculator = new StringCalculator();
    }

    //  Feature - 1
    @Test
    public void AddNo() {

        //  Empty String
        String str = "";
        long expected = 0;
        long actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        // Single String
        str = "1";
        expected = 1;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        // Two String
        str = "1,2";
        expected = 3;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        // Three String
        str = "1,2,3";
        expected = 6;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);
    }

    //  Feature - 2
    @Test(expected = InputException.class)
    public void unknownAmountOfNumber() {
        String str = "1,2,3,4";

        stringCalculator.Add(str);
    }

}
