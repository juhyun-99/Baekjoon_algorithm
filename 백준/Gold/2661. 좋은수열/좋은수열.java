import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] sel;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sel = new int[n];
        /*
         * 11
         * 1212
         * 123123
         * 123(11)231 이므로 3개까지만 확인하면 되지 않나???
         *
         * 근데 10 넣으니까 12/1312/1312 이거임..
         * */
        recursive(0);


    }

    private static void recursive(int cur) {
        if(cur == n){
            for (int i = 0; i < n; i++) {
                sb.append(sel[i]);
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }

        for (int i = 1; i < 4; i++) {
            sel[cur] = i;
            if(cur > 0 && !check(cur)) continue;
            recursive(cur + 1);
        }
    }

    private static boolean check(int cur) {
        /*
        0

        1 end = 1
        sel[cur] == sel[cur - 1]

        2 end = 1
        sel[cur] == sel[cur - 1]

        3 end = 2
        sel[cur] == sel[cur - 1]

        sel[cur] == sel[cur - 2]
        sel[cur - 1] == sel[cur - 3]

        4 end = 2
        sel[cur] == sel[cur - 1]

        sel[cur] == sel[cur - 2]
        sel[cur - 1] == sel[cur - 3]

        * */
        int end = (cur + 1) / 2;
        //System.out.println(cur + " " + Arrays.toString(sel));
        for (int i = 1; i <= end; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                //System.out.println(cur - j + " " + (cur - j - i));
                if(sel[cur - j] == sel[cur - j - i]) {
                    cnt++;
                }
            }
            if(cnt == i) return false;
        }
        return true;
    }


}
