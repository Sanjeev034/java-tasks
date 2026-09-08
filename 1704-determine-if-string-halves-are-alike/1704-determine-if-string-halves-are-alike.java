class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2);

        int vowelsA = countVowels(a);
        int vowelsB = countVowels(b);

        return vowelsA == vowelsB;
    }

    private int countVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
