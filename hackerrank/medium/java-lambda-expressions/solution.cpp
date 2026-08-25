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