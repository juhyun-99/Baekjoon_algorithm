import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static int dp[][];

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recursive(0, n - 1));
    }

    private static int recursive(int start, int end) {
        //System.out.println(start + " " + end);
        if(start >= end) return 0;

        if(dp[start][end] != -1) return dp[start][end];
        int ret = 0;

        //값이 다를 때
        if(arr[start] != arr[end]){
            //뒤쪽에 값을 넣었을 때와  앞쪽에 값을 넣었을 때랑 비교함.
            ret = Math.min(recursive(start + 1, end) + 1, recursive(start, end - 1) + 1);
        }
        else{ //값이 같을 때
            ret += recursive(start + 1, end - 1);
        }

        dp[start][end] = ret;
        return dp[start][end];
    }
}
