import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        // Create an array of String arrays to store pairs of [height, name]
        String[][] people = new String[n][2];
        for (int i = 0; i < n; i++) {
            people[i][0] = String.valueOf(heights[i]); // Store height as string for easy comparison
            people[i][1] = names[i];
        }

        // Sort the people array in descending order based on height
        // We use a custom comparator
        Arrays.sort(people, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                // Compare heights in descending order
                return Integer.compare(Integer.parseInt(b[0]), Integer.parseInt(a[0]));
            }
        });

        // Extract the sorted names into a new array
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i][1];
        }

        return sortedNames;
    }
}
