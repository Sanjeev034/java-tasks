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

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-25T04:39:53.600Z  

```cpp
            int condition = Integer.parseInt(input[0]);
            int number = Integer.parseInt(input[1]);

            boolean result;

            if (condition == 1) {
                result = MyMath.checker(
                        MyMath.isOdd(), number);

                System.out.println(result ? "ODD" : "EVEN");

            } else if (condition == 2) {
                result = MyMath.checker(
                        MyMath.isPrime(), number);

                System.out.println(result ? "PRIME" : "COMPOSITE");

            } else {
                result = MyMath.checker(
                        MyMath.isPalindrome(), number);

                System.out.println(
                        result ? "PALINDROME" : "NOT PALINDROME");
            }
        }
    }
}
```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-lambda-expressions/problem)