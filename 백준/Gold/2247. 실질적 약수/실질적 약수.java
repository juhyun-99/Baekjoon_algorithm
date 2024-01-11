import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*
        1 = 0
        2 = 0
        3 = 0
        4 = 2
        5 = 0
        6 = 2, 3 = 5
        7 = 0
        8 = 2, 4  = 2 2 2 = 6
        9 = 3
        10 = 2, 5 = 7
        11 = 0
        12 = 2, 3, 4, 6

========================================================
    `   4 = 2
        5 = 2
        6 = 2 2 3 = 7
        7 = 7
        8 = 2 2 3 2 4 = 13

        */
        long sum = 0;
        for (int i = 2; i < n; i++) {
            //System.out.println(i + " " + (n/i - 1) * i);
            sum += (n / i - 1) * i;
        }
        System.out.println(sum % 1000000);
    }
}
