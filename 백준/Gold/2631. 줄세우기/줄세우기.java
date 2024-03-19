import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < i ; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(n - ans);
    }

}