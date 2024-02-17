import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] sel;
    static boolean[] visit;
    static int ans = Integer.MIN_VALUE;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sel = new int[n];
        visit = new boolean[n];
        recursive(0);
        System.out.println(ans);

    }

    private static void recursive(int cur) {
        if(cur == n){
            //System.out.println(Arrays.toString(sel));
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += Math.abs(sel[i - 1] - sel[i]);
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;
            sel[cur] = arr[i];
            visit[i] = true;
            recursive(cur + 1);
            visit[i] = false;
        }
    }
}
