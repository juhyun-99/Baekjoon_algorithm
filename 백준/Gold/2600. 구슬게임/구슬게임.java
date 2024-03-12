import java.util.*;
import java.io.*;

public class Main {
    static int[] brr, arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        brr = new int[3];

        for (int i = 0; i < 3; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[2][501][501];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 501; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        /*
        *   4 1
        *       a   b
        * 1   (3,1)
        * 2         (2,1)
        * 3   (1,1)
        * 4         (0,1)
        * 5    (0,0) a가 이김
        *
        *
        *       a   b
        * 1   (1,1)
        * 2         (0,1)
        * 3   (0,0) a가 이김
        *
        *        a   b
        * 1   (4,0)
        * 2         (0,0) b
        *
        * 처음 a가 어떻게 뽑냐에 따라서 달라짐
        * */
        for (int test = 0; test < 5; test++) {
            arr = new int[2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append((recursive(1, arr[0], arr[1]) == 1? 'A' : 'B') + "\n");
        }
        System.out.println(sb);
    }

    public static int recursive(int num, int k1, int k2){
        int nxt = num == 1 ? 0 : 1;
//        System.out.println(num + " " + k1 + " " + k2);
        if(dp[num][k1][k2] != -1) return dp[num][k1][k2];

        int ret = 0;
        for (int i = 0; i < 3; i++) {
            //a가 뽑은 후 -> 남은 구슬에서 승자가 b이면 a 승자
            if(k1 >= brr[i] && recursive(nxt, k1 - brr[i], k2) != 1){
                ret = 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            if(k2 >= brr[i] && recursive(nxt, k1, k2 - brr[i]) != 1){
                ret = 1;
            }
        }
        return dp[num][k1][k2] = ret;
    }
}
