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


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna