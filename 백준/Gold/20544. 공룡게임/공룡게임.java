import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;
public class Main {
    static int n;
    static long answer;
    static int[][][][] dp = new int[1001][3][3][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
//        System.out.println(recursive(1, 0, 0,false));
        System.out.println(recursive(1, 0, 0,0));
    }

//    private static void recursive(int cur, int cnt, int two, boolean tf) {
//        if(cnt > 2 || two == 2) return;
//        if(cur == n){
//            if(!tf) return;
//            answer++;
//            return;
//        }
//
//        recursive(cur + 1, 0, 0, tf); //아무것도 선택안함
//        recursive(cur + 1, cnt + 1, 0, tf); //1개짜리 선택
//        recursive(cur + 1, cnt + 1, two + 1,true); //2개 짜리 선택
//    }
//
//    private static int recursive(int cur, int cnt, int two, boolean tf) {
//        if(cnt > 2 || two == 2) return 0;
//        if(cur == n){
//            if(!tf) return 0;
//            answer++;
//            return 1;
//        }
//        int ans = 0;
//        ans += recursive(cur + 1, 0, 0, tf) % 1000000007; //아무것도 선택안함
//        ans += recursive(cur + 1, cnt + 1, 0, tf) % 1000000007; //1개짜리 선택
//        ans += recursive(cur + 1, cnt + 1, two + 1,true) % 1000000007; //2개 짜리 선택
//        return ans;
//    }

    private static int recursive(int cur, int cnt, int two, int tf) {
        if(cnt > 2 || two == 2) return 0;
        if(dp[cur][cnt][two][tf] != -1) return dp[cur][cnt][two][tf];
        if(cur == n){
            if(tf == 0) return 0;
            return 1;
        }

        int ans = 0;
        ans = (ans + recursive(cur + 1, 0, 0, tf)) % 1000000007; //아무것도 선택안함
        ans = (ans + recursive(cur + 1, cnt + 1, 0, tf)) % 1000000007; //1개짜리 선택
        ans = (ans + recursive(cur + 1, cnt + 1, two + 1,1)) % 1000000007; //2개 짜리 선택
        dp[cur][cnt][two][tf] = ans;
        return ans;
    }
}