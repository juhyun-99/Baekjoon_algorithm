import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] num;
    static int[] opp = new int[4];
    static int[] visit = new int[4];
    static int[] sel;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opp[i] = Integer.parseInt(st.nextToken());
        }
        sel = new int[n - 1];

        recursive(0);
        System.out.println(max);
        System.out.println(min);

    }

    private static void recursive(int cur) {
        if(cur == n - 1){
            //System.out.println(Arrays.toString(sel));
            calc();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(visit[i] >= opp[i]) continue;
            sel[cur] = i;
            visit[i]++;
            recursive(cur + 1);
            visit[i]--;
        }
    }

    private static void calc() {
        int cal = num[0];
        for (int i = 0; i < sel.length; i++) {
            if(sel[i] == 0){
                cal += num[i + 1];
            }else if(sel[i] == 1){
                cal -= num[i + 1];
            }else if(sel[i] == 2){
                cal *= num[i + 1];
            }else{
                cal /= num[i + 1];
            }
        }
        max = Math.max(max, cal);
        min = Math.min(min, cal);
    }
}
