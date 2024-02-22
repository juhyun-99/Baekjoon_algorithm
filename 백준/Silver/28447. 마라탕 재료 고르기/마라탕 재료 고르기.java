import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, k;
    static int[] sel;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        /*
        * k개의 재료를 넣었을 때 마라탕의 맛을 최대로
        * cij는 ij 넣었을 때 궁합 맛의 궁합은 음수일 수 있음.
        *
        * */
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sel = new int[k];
        recursive(0, 0);
        if(k == 1){
            ans = 0;
        }

        System.out.println(ans);

    }

    private static void recursive(int cur, int start) {
        if(cur == k){
            int sum = 0;
            //System.out.println(Arrays.toString(sel));
            for (int i = 0; i < cur - 1; i++) {
                for (int j = i + 1; j < cur; j++) {
                    //System.out.println(i +" " + j);
                    sum += arr[sel[i]][sel[j]];
                }
            }
            //System.out.println(sum);
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = start; i < n; i++) {
            sel[cur] = i;
            recursive(cur + 1, i + 1);
        }
    }
}
