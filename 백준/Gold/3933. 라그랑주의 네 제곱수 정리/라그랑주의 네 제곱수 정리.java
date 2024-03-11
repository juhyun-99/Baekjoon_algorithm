import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int dp[][][];
    static int n, sqN, max = 32769;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[max][5][256];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int test = 0; test < 255; test++) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            sqN = (int) Math.sqrt(n);
            sb.append(recursive(n, 0, sqN) + "\n");
        }
        System.out.println(sb);
    }

//    private static void recursive(int num, int cnt, int start){
//        if(num > n) return;
//        if(cnt > 4) return;
//        if(num == n){
//            ans++;
//            return;
//        }
//        for (int i = start; i >= 1; i--) {
//            recursive(num + i*i, cnt + 1, i);
//        }
//    }

//    private static int recursive(int num, int cnt, int start){
//        if(num > n) return 0;
//        if(cnt > 4) return 0;
//        if(num == n){
//            return 1;
//        }
//        int ret = 0;
//        for (int i = start; i >= 1; i--) {
//            ret += recursive(num + i*i, cnt + 1, i);
//        }
//        return ret;
//    }

    private static int recursive(int num, int cnt, int start){
        if(start < 0) return 0;
        if(num < 0) return 0;
        if(cnt > 4) return 0;
        if(num == 0){
            return 1;
        }

        if(dp[num][cnt][start] != -1) return dp[num][cnt][start];

        int ret = recursive(num - start * start, cnt + 1, start);
        ret += recursive(num, cnt, start - 1);

        return dp[num][cnt][start] = ret;
    }
}
