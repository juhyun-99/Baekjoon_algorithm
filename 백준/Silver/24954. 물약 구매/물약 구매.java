import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;

    static boolean[] visit;
    static int[][] discount;
    static int[] sel;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        discount = new int[n][n];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                discount[i][a - 1] = b;
            }
        }

        sel = new int[n];
        recursive(0);
        System.out.println(ans);
    }

    private static void recursive(int cur) {
        if(cur == n){
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = arr[i];
            }
            boolean[] buy = new boolean[n];
            for (int i = 0; i < n; i++) {
                buy[sel[i]] = true;
                for (int j = 0; j < n; j++) {
                    if(discount[sel[i]][j] != 0 && !buy[j]){
                        tmp[j] -= discount[sel[i]][j];
                    }
                }
            }
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += tmp[i] <= 0 ? 1 : tmp[i];
            }

            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            sel[cur] = i;
            recursive(cur + 1);
            visit[i] = false;
        }
    }
}