import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];

    static long dp[][][][];
    static int w, h;

    static int dx[] = {0, 0, 1};
    static int dy[] = {0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        dp = new long[101][101][3][2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                dp[w][h][i][j] = 1;
            }
        }

        for (int x = w; x >= 1 ; x--) {
            for (int y = h; y >= 1 ; y--) {
                if(x == w && y == h) continue;
                for (int d = 2; d >= 0; d--) {
                    for (int turn = 1; turn >= 0; turn--) {
                        dp[x][y][d][turn] = 0;
                        for (int i = 1; i <= 2; i++)
                        {
                            int dir = d;
                            int t = turn;
                            if(x == 1 && y == 1) dir = i;
                            int nx = x + dx[i];
                            int ny = y + dy[i];
                            if(!check(nx, ny)) continue;
                            if(dir != i){
                                if(turn == 1) continue;
                                t = 1;
                            }
                            else{
                                t = 0;
                            }
                            dp[x][y][d][turn] = (dp[x][y][d][turn] + dp[nx][ny][i][t]) % 100000;
                        }
                    }
                }

            }
        }

        System.out.println(dp[1][1][0][0]);
    }

    public static boolean check(int nx, int ny){
        if(1 <= nx && nx <= w && 1 <= ny && ny <= h) return true;
        return false;
    }
}
