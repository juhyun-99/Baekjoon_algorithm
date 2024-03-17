import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i] += 1;
        }
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(ans);
    }

}
