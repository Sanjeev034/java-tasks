            "FRIDAY",
            "SATURDAY"
        };

        return days[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        int month = Integer.parseInt(input[0]);
        int day = Integer.parseInt(input[1]);
        int year = Integer.parseInt(input[2]);

        String result = Result.findDay(month, day, year);

        System.out.println(result);

        bufferedReader.close();
    }
}