
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Player[] player = new Player[n];

        for (int i = 0; i < n; i++) {
            player[i] = new Player(
                scan.next(),
                scan.nextInt()
            );
        }

        Checker checker = new Checker();

        Arrays.sort(player, checker);

        for (Player p : player) {
            System.out.println(p.name + " " + p.score);
        }

        scan.close();
    }
}