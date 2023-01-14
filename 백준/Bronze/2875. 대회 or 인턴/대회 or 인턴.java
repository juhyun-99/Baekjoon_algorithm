import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            if(n - i < 0 | m - (k - i) < 0) continue;
            int num1 = (n - i)/2, num2 = m -(k - i);
            int team;
            if(num1 <= num2) team = num1;
            else team = num2;

            if(team > ans) ans = team;
        }
        System.out.println(ans);
    }
}