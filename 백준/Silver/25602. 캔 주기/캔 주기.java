import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] a;

    static int[][] r, m;
    static int[] visit ;
    static int[] sel;
    static int ans = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        visit = new int[n];
        sel = new int[k * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        r = new int[k][n];
        m = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                r[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0);
        System.out.println(ans);
    }

    private static void recursive(int cur) {
        if(cur == k * 2){
            int sum = 0;
            for (int i = 0; i < 2 * k; i++) {
                if(i % 2 == 0){
                    sum += r[i/2][sel[i]];
                }else{
                    sum += m[i/2][sel[i]];
                }
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visit[i] >= a[i]) continue;
            sel[cur] = i;
            visit[i]++;
            recursive(cur + 1);
            visit[i]--;
        }
    }


}
