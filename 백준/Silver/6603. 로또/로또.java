import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] s;
    static int[] sel;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        while(k != 0){
            s = new int[k];
            sel = new int[6];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            recursive(0, 0);
            sb.append("\n");

            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

        }
        System.out.println(sb);


    }

    private static void recursive(int cur, int start) {
        if(cur == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            sel[cur] = s[i];
            recursive(cur + 1, i + 1);
        }
    }
}
