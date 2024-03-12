import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr, dp;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, recursive(i, j));
            }
        }
        System.out.println(ans);
    }

    public static int recursive(int x, int y){
        if(dp[x][y] != -1) return dp[x][y];
        int ret = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!check(x, y, nx, ny)){
                continue;
            }
            ret = Math.max(ret, recursive(nx, ny) + 1);
        }
        return dp[x][y] = ret;
    }

    private static boolean check(int x, int y, int nx, int ny) {
        if(0 <= nx && nx < n && 0 <= ny && ny < n){
            if(arr[x][y] < arr[nx][ny]) return true;
        }
        return false;
    }

}
