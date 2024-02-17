import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        cnt = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            recursive(0, 0, i, 0);
        }
        System.out.println(cnt);


    }

    private static void recursive(int cur, int start, int end, int sum) {
        if(cur == end){
            if(sum == s){
                cnt++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            recursive(cur + 1, i + 1, end, sum + arr[i]);
        }
    }
}
