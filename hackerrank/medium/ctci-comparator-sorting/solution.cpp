
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            players[i] = new Player(
                scan.next(),
                scan.nextInt()
            );
        }

        Checker checker = new Checker();

        Arrays.sort(players, checker);

        for (Player player : players) {
            System.out.println(
                player.name + " " + player.score
            );
        }

        scan.close();
    }
}