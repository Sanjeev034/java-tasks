import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {

            int num = sc.nextInt();

            // Add new element to deque
            deque.addLast(num);

            // Increase frequency
            map.put(num, map.getOrDefault(num, 0) + 1);

            // When window size becomes m
            if (deque.size() == m) {

                // Number of unique elements
                maxUnique = Math.max(maxUnique, map.size());

                // Remove element from front
                int removed = deque.removeFirst();

                // Decrease its frequency
                map.put(removed, map.get(removed) - 1);

                // Remove from map if frequency becomes zero
                if (map.get(removed) == 0) {
                    map.remove(removed);
                }
            }
        }

        System.out.println(maxUnique);

        sc.close();
    }
}
