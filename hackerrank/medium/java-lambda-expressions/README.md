# Java Lambda Expressions

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

This Java 8 challenge tests your knowledge of [Lambda expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)!

Write the following methods that *return a lambda expression* performing a specified action:

1. PerformOperation isOdd(): The lambda expression must return $true$ if a number is odd or $false$ if it is even.
2. PerformOperation isPrime(): The lambda expression must return $true$ if a number is prime or $false$ if it is composite.
3. PerformOperation isPalindrome(): The lambda expression must return $true$ if a number is a palindrome or $false$ if it is not.

**Input Format**

Input is handled for you by the locked stub code in your editor.

**Constraints**

 

**Output Format**

The locked stub code in your editor will print $T$ lines of output.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-25T04:39:43.381Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-lambda-expressions/problem)