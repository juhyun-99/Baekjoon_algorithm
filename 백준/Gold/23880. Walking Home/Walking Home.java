import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char arr[][];
    static int dp[][][][];
    static int n, k, ans;

    //하, 우
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            dp = new int[n][n][3][k + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < k + 1; m++) {
                            dp[i][j][l][m] = -1;
                        }
                    }
                }
            }

            arr = new char[n][n];

            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().toCharArray();
            }
            ans = recursive(0, 0, 2, 0);
//            System.out.println(ans);
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }

    private static int recursive(int x, int y, int d, int cnt) {
        //System.out.println(x + " " + y + " " + d + " " + cnt);
        if(!check(x, y)) return 0;
        if(cnt > k) return 0;
        
        if(x == n - 1 && y == n - 1){
            return 1;
        }
        if(dp[x][y][d][cnt] != -1) return dp[x][y][d][cnt];

        int dir = d;
        int plus = 1;
        if(d == 2) {
            dir = 0;
            plus = 0;
        }
        int ret = recursive(x + dx[dir], y + dy[dir], dir, cnt); //방향 그대로
        int tmp = dir == 0 ? 1 : 0;
        ret += recursive(x + dx[tmp], y + dy[tmp], tmp, cnt + plus); //방향 바꿈

        return dp[x][y][d][cnt] = ret;
    }

    private static boolean check(int x, int y) {
        if(0 <= x && x < n && 0 <= y && y < n && arr[x][y] == '.') return true;
        return false;
    }


}
