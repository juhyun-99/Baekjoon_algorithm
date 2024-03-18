import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 위, 왼쪽, 왼쪽 위, 오른쪽 위
    static int[] dx = {-1, 0, -1, -1};
    static int[] dy = {0, -1, -1, 1};
    static int n;
    static int[][] arr;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n][2][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        dp = new int[n][n][2][4];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (arr[x][y] == 1) { //흑돌일 때
                    for (int d = 0; d < 4; d++) { //바꾸고 안바꾸고, 방향 모두 1
                        dp[x][y][0][d] = 1;
                        dp[x][y][1][d] = 1;
                    }
                }

                if (arr[x][y] == 2) { //백돌일 때
                    for (int d = 0; d < 4; d++) { //안바꾼거, 방향 1
                        dp[x][y][0][d] = 1;
                    }
                }
            }
        }


        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(0 <= nx && nx < n && 0 <= ny && ny < n){
                        if(arr[nx][ny] == 1) { // 흑돌일 때, 전 방향에 있던거 더해주기
                            dp[x][y][0][d] += dp[nx][ny][0][d];
                            dp[x][y][1][d] += dp[nx][ny][1][d];
                        }
                        else if(arr[nx][ny] == 2){//백돌 일 때, 전 방향에 안바꿨던거 더하기
                            dp[x][y][1][d] += dp[nx][ny][0][d];
                        }
                    }
                    ans = Math.max(ans, dp[x][y][0][d]);
                    ans = Math.max(ans, dp[x][y][1][d]);
                }
            }
        }

        System.out.println(ans);
    }
}


