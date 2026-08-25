# Java Arraylist

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Sometimes it's better to use dynamic size arrays. Java's  [Arraylist](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html) can provide you this feature. Try to solve this problem using Arraylist.<br>

You are given $n$ lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in $y^{th}$ position of $x^{th}$ line. <br>

Take your input from System.in.

**Input Format**<br>
The first line has an integer $n$. In each of the next $n$ lines there will be an integer $d$ denoting number of integers on that line and then there will be $d$ space-separated integers. In the next line there will be an integer $q$ denoting number of queries. Each query will consist of two integers $x$ and $y$.

**Constraints**<br>

* $1<=n<=20000$
* $0<=d<=50000$
* $1<=q<=1000$
* $1<=x<=n$

Each number will fit in signed integer.<br>
Total number of integers in $n$ lines will not cross $10^5$.<br>

**Output Format**<br>
In each line, output the number  located in $y^{th}$ position of $x^{th}$ line. If there is no such position, just print "ERROR!"



**Input Format**

 

**Constraints**

 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-25T04:35:43.545Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        // Number of lines
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Read each line
        for (int i = 0; i < n; i++) {

            String[] input = br.readLine().split(" ");

            int d = Integer.parseInt(input[0]);

            ArrayList<Integer> numbers = new ArrayList<>();

            for (int j = 1; j <= d; j++) {
                numbers.add(Integer.parseInt(input[j]));
            }

            list.add(numbers);
        }

        // Number of queries
        int q = Integer.parseInt(br.readLine());

        // Process queries
        for (int i = 0; i < q; i++) {

            String[] query = br.readLine().split(" ");

            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);

            try {
                // x and y are 1-based
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }

        br.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-arraylist/problem)