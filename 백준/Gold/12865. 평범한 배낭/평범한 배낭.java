import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[][], dp[][];
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        dp = new int[n + 2][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recursive(0, 0));
    }


    //백트
//    private static void recursive(int cur, int weight, int price) {
//        if(weight > k) return;
//        if(cur == n) {
//            ans = Math.max(price, ans);
//            return;
//        }
//
//        //선택함
//        recursive(cur + 1, weight + arr[cur][0], price + arr[cur][1]);
//
//        //선택안함
//        recursive(cur + 1, weight, price);
//    }


    //함수형태
//    private static int recursive(int cur, int weight) {
//        if(weight > k) return -99999999;
//        if(cur == n) {
//            return 0;
//        }
//
//        //선택함
//        int ret = recursive(cur + 1, weight + arr[cur][0]) + arr[cur][1];
//        return ret = Math.max(ret, recursive(cur + 1, weight)); //선택안함과 비교
//    }


    //메모이제이션 추가
    private static int recursive(int cur, int weight) {
        if(weight > k) return -99999999;
        if(cur == n) {
            return 0;
        }
        if(dp[cur][weight] != -1) return dp[cur][weight];

        //선택함
        dp[cur][weight] = recursive(cur + 1, weight + arr[cur][0]) + arr[cur][1];
        return dp[cur][weight] = Math.max(dp[cur][weight], recursive(cur + 1, weight)); //선택안함과 비교
    }
}
