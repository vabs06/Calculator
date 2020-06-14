import static org.junit.Assert.*;

import exception.InputException;
import exception.NegativeNumberException;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();
    private String str;
    private long actual, expected;

    @Before
    public void getNewInstance() {
        str = "";
        expected = 0;
        actual = 0;
    }

    @Test
    public void intitalAddCountValue() {
        System.out.println(StringCalculator.addCallCount);
    }

    //  Feature - 1
    @Test
    public void AddNo() {

        //  Empty String
        str = "";
        expected = 0;
        actual = stringCalculator.Add(str);
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
    public void shouldHandleUnknownAmountOfNumber() {
        str = "1,2,3,4";
        stringCalculator.Add(str);
    }

    //  Feature - 3
    @Test(expected = InputException.class)
    public void shouldHandleNewLineDelimiters() {
        str = "1\n2,3";
        expected = 6;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        str = "1,\n2,3";
        stringCalculator.Add(str);
    }

    //  Feature - 4, 10, 11, 12
    @Test
    public void shouldSupportDifferentDelimiters() {
        //  1
        str = "//;\n1;2";
        expected = 3;
        actual = stringCalculator.Add(str);
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

    //  Feature - 9
    @Test
    public void shouldIgnoreBiggerNumbers() {
        //  No within range
        str = "2,1000";
        expected = 1002;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        //  No out-of-range
        str = "2,1001";
        expected = 2;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);

        str = "5,1050,1000";
        expected = 1005;
        actual = stringCalculator.Add(str);
        assertEquals(expected, actual);
    }

    // Feature - 5, 6
    @Test
    public void shouldHandleNegativeNumbers() {
        String expect = "";
        //  1
        str = "-1";
        try {
            stringCalculator.Add(str);
            fail();
        } catch ( NegativeNumberException nne) {
            expect = StringCalculator.NEG_NA + " " + stringCalculator.negativeList.toString();
            assertEquals(expect, nne.getMessage());
            System.out.println(expect);
            stringCalculator.negativeList.clear();
        }

        //  2
        str = "-1,2,-3";
        try {
            stringCalculator.Add(str);
            fail();
        } catch ( NegativeNumberException nne) {
            expect = StringCalculator.NEG_NA + " " + stringCalculator.negativeList.toString();
            assertEquals(expect, nne.getMessage());
            System.out.println(expect);
            stringCalculator.negativeList.clear();
        }
    }


    //  Feature - 7
    @Test
    public void getCalledCount() {
        expected = StringCalculator.addCallCount;
        actual = stringCalculator.GetCalledCount();
        assertEquals(expected, actual);
        System.out.println(String.format("Expect: %x, Actual: %x", expected, actual));
    }
}
