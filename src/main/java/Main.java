import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator();

        String s1 = "//;\n1;2";
        int ans = stringCalculator.Add(s1);
        System.out.println(ans);

        String s2 = "1\n2,3";
        ans = stringCalculator.Add(s2);
        System.out.println(ans);

        String s3 = "//[*][%]\n1*6%3";
        ans = stringCalculator.Add(s3);
        System.out.println(ans);

        String s4 = "-1";
        ans = stringCalculator.Add(s4);
        System.out.println(ans);

        sc.close();
    }
}
