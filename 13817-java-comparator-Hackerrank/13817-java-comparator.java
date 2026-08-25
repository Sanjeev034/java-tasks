import java.util.*;

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {

        // Higher score first
        if (a.score != b.score) {
            return b.score - a.score;
        }

        // Same score -> alphabetical order
        return a.name.compareTo(b.name);
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Player[] player = new Player[n];

        for (int i = 0; i < n; i++) {
            player[i] = new Player(
                scan.next(),
                scan.nextInt()
            );
        }

        Checker checker = new Checker();

        Arrays.sort(player, checker);

        for (Player p : player) {
            System.out.println(p.name + " " + p.score);
        }

        scan.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna