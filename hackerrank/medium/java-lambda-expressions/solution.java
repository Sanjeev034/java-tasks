import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // 1. Check Odd or Even
    public static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    // 2. Check Prime or Composite
    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a < 2)
                return false;

            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0)
                    return false;
            }

            return true;
        };
    }

    // 3. Check Palindrome
    public static PerformOperation isPalindrome() {
        return (int a) -> {
            int original = a;
            int reverse = 0;

            while (a != 0) {
                int digit = a % 10;
                reverse = reverse * 10 + digit;
                a /= 10;
            }

            return original == reverse;
        };
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {

            String[] input = br.readLine().split(" ");

            int condition = Integer.parseInt(input[0]);
            int number = Integer.parseInt(input[1]);

            boolean result;

            if (condition == 1) {
                result = MyMath.checker(
                        MyMath.isOdd(), number);

                System.out.println(result ? "ODD" : "EVEN");

            } else if (condition == 2) {
                result = MyMath.checker(
                        MyMath.isPrime(), number);

                System.out.println(result ? "PRIME" : "COMPOSITE");

            } else {
                result = MyMath.checker(
                        MyMath.isPalindrome(), number);

                System.out.println(
                        result ? "PALINDROME" : "NOT PALINDROME");
            }
        }
    }
}
