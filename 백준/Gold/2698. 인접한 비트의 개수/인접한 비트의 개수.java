import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[][][] dp = new int[101][101][2];
        /*
       마지막이 0이면 증가 안함
        * 0 -> 0 -> [1][0][0]
        * 1 -> 0 -> [1][0][1]

        * 00 -> 0 -> [2][0][0]
        * 10 -> 0  ->[2][0][0]
        * 01 -> 0 -> [2][0][1]
        * 11 -> 1 -> [2][1][1] -> [1][0][1]

        * 111 -> 2 -> [3][2][1] -> [2][1][1]
        * 011 -> 1 -> [3][1][1] -> [2][0][1]
        * 001 -> 0 -> [3][0][1] -> [2][0][0]
        * 101 -> 0 -> [3][0][1] -> [2][0][0]

        * 110 -> 1 -> [3][1][0] -> [2][1][1]
        * 100 -> 0 -> [3][0][0] -> [2][0][0]
        * 000 -> 0 -> [3][0][0] -> [2][0][0]
        * 010 -> 0 -? [3][0][0] -? [2][0][1]
        * */

        dp[1][0][1] = 1; dp[1][0][0] = 1;

        for (int i = 2; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if(j == 0){
                    dp[i][j][1] = dp[i - 1][j][0];
                }else{
                    dp[i][j][1] = dp[i - 1][j][0] + dp[i - 1][j - 1][1];
                }
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
            }
        }
        for (int test = 0; test < t; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(dp[n][k][0] + dp[n][k][1] + "\n");
        }

        System.out.println(sb);

    }
}


