import java.util.*;
import java.io.*;

public class Main {
    static int n, m, h;
    static int ans = Integer.MAX_VALUE;
    static int[][] arr, dp;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recursive(0, 0));


    }

    public static int recursive(int x, int y){
        if(x == n - 1 && y == m - 1){
            return 1;
        }

        if(dp[x][y] != -1) return dp[x][y];

        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!check(x, y, nx, ny)){
                continue;
            }
            ret += recursive(nx, ny);
        }
        return dp[x][y] = ret;
    }

    private static boolean check(int x, int y, int nx, int ny) {
        if(0 <= nx && nx < n && 0 <= ny && ny < m){
            if(arr[x][y] > arr[nx][ny]) return true;
        }
        return false;
    }

}
