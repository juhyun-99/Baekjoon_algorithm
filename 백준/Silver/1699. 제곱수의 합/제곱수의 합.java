import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static int dp[];
    static int n, sqN, ans = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sqN = 0;
        for (int i = 0; i * i <= n; i++) {
            sqN = i;
        }
        dp = new int[n + 1];
        Arrays.fill(dp, 1000000);
        System.out.println(recursive(0));
    }

//    private static void recursive(int num, int cnt){
//        if(num > n) return;
//        if(num == n){
//            ans = Math.min(ans, cnt);
//            return;
//        }
//        for (int i = sqN; i >= 1; i--) {
//            recursive(num + i*i, cnt + 1);
//        }
//    }

//    private static int recursive(int num){
//        if(num > n) return 1000000;
//        if(num == n){
//            return 0;
//        }
//        int ret = Integer.MAX_VALUE;
//        for (int i = sqN; i >= 1; i--) {
//            ret = Math.min(ret, recursive(num + i * i) + 1);
//        }
//        return ret;
//    }

    private static int recursive(int num){
        if(num > n) return 1000000;
        if(num == n){
            return 0;
        }
        if(dp[num] != 1000000) return dp[num];

        for (int i = sqN; i >= 1; i--) {
            dp[num] = Math.min(dp[num], recursive(num + i * i) + 1);
        }
        return dp[num];
    }
}
