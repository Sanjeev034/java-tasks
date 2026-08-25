            }

            list.add(numbers);
        }

        // Number of queries
        int q = Integer.parseInt(br.readLine());

        // Process queries
        for (int i = 0; i < q; i++) {

            String[] query = br.readLine().split(" ");

            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);

            try {
                // x and y are 1-based
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }

        br.close();
    }
}