import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, l ,r ,x;
    static int[] arr;
    static int cnt;
    static int[] sel;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*
        * 캠프에 사용할 문젠느 2문제 이상
        * 난이도 합 L보다 크거나 같고 R보다 작거나 같아야함
        * 가장 어려운 문제 - 가장 쉬운 문제 >= x 여야함.
        * */

        for (int i = 2; i <= n; i++) {
            sel = new int[i];
            recursive(0, 0, i);
        }
        System.out.println(cnt);

    }

    private static void recursive(int cur, int start, int end) {
        if(cur == end){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < sel.length; i++) {
                sum += sel[i];
                max = Math.max(max, sel[i]);
                min = Math.min(min, sel[i]);
            }
            if(sum >= l && sum <= r && (max - min) >= x){
                //System.out.println(Arrays.toString(sel));
                cnt++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            sel[cur] = arr[i];
            recursive(cur + 1, i + 1, end);
        }
    }

}
