import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    static int dp[][];
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(recursive(a - 1, b - 1) + "\n");
        }
        System.out.println(sb);
    }

    private static int recursive(int start, int end) {
        if(start >= end) return 1;

        if(dp[start][end] != -1) return dp[start][end];
        int ret = 0;

        if(arr[start] != arr[end]){
            return 0;
        }
        else{
            ret = recursive(start + 1, end - 1);
        }
        dp[start][end] = ret;
        return dp[start][end];
    }
}