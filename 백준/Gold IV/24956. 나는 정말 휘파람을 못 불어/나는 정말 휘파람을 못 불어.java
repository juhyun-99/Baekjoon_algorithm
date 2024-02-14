import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long w = 0;
        long mod = 1000000007;
        long wh = 0;
        long whe = 0;
        long whee = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'W') {
                w++;
            } else if (s.charAt(i) == 'H') {
                wh += w;
            } else if (s.charAt(i) == 'E') {
                whee = 2 * whee;
                whee += whe;
                whee %= mod;
                whe += wh;
            }
        }

        System.out.println(whee);
    }
}
