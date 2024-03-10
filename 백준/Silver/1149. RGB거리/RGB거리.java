import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[][], dp[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][3];
        dp = new int[n + 2][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recursive(0, -1));
    }

    private static int recursive(int cur, int previous) {
        if(cur == n) {
            return 0;
        }

        if (previous != -1 && dp[cur][previous] != -1) return dp[cur][previous];

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if(i == previous) continue;
            ret = Math.min(ret, recursive(cur + 1, i) + arr[cur][i]);
        }
        if(previous != -1) dp[cur][previous] = ret;
        return ret;
    }
}
