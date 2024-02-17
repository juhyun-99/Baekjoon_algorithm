import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] sel;
    static ArrayList<String> list = new ArrayList();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        for (int i = n; i >= 1; i--) {
            sel = new int[i];
            recursive(0, i, 0);
        }
        Collections.sort(list);
//        System.out.println(list.toString());

        if(list.size() < k){
            System.out.println(-1);
        }else{
            System.out.println(list.get(k - 1));
        }
    }


    private static void recursive(int cur, int end, int sum) {
        if(sum > n) return;

        if(cur == end && sum <= n){
            if(sum < n) return;
            String tmp = "";
            for (int i = 0; i < sel.length; i++) {
                if(i == sel.length - 1){
                    tmp += sel[i];
                }else{
                    tmp += sel[i] + "+";
                }
            }
            list.add(tmp);
            return;
        }

        for (int i = 1; i < 4; i++) {
            sel[cur] = i;
            recursive(cur + 1, end, sum + i);
        }

    }
}
