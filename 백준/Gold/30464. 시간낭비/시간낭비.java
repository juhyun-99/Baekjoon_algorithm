import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[][][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = recursive(1, 0, 0);
        System.out.println(ans > 0 ? ans : -1);
    }

    private static int recursive(int num, int d, int turn) {
        if(num < 1 || num > n) return Integer.MIN_VALUE;
        if(num == n) return 0;

        if(dp[num][d][turn] != -1) return dp[num][d][turn];

        int ret = Integer.MIN_VALUE;

        //그냥 가기
        int dis = d == 0 ? arr[num] : -arr[num];
        if(dis == 0) return Integer.MIN_VALUE;
        ret = Math.max(ret, recursive(num + dis, d, turn) + 1);


        //방향 전환
        if(turn < 2){
            int dir = 1 - d;
            ret = Math.max(ret, recursive(num - dis, dir, turn + 1) + 1);
        }
        return dp[num][d][turn] = ret;
    }
}
