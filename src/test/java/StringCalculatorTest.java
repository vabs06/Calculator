import static org.junit.Assert.*;

import exception.InputException;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

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

    //  Feature - 3
    @Test(expected = InputException.class)
    public void shouldHandleNewLineDelimiters() {
        String str = "1\n2,3";
        long expected = 6;
        long actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        str = "1,\n2,3";
        stringCalculator.Add(str);
    }

    //  Feature - 4, 10, 11, 12
    @Test
    public void shouldSupportDifferentDelimiters() {
        //  1
        String str = "//;\n1;2";
        long expected = 3;
        long actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        //  2
        str = "//[***]\n1***3***3";
        expected = 7;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        //  3
        str = "//[*][%]\n1*6%3";
        expected = 10;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        //  4
        str = "//[**][%%]\n10**20%%30";
        expected = 60;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

    }
}
