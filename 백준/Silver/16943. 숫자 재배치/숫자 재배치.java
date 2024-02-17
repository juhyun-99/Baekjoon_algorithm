import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static String a;
    static ArrayList<Integer> check = new ArrayList<>();
    static int b;
    static boolean[] visit;
    static int ans = -1;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        b = Integer.parseInt(st.nextToken());


        for(int i = 0; i < a.length(); i++){
            check.add(a.charAt(i) - '0');
        }
        visit = new boolean[check.size()];

        Collections.sort(check);
        recursive(0, "");
        System.out.println(ans);
    }


    private static void recursive(int cur, String tmp) {
        if(cur == check.size()){
            int num = Integer.parseInt(tmp);
            if(num < b){
                ans = Math.max(ans, num);
            }
            return;
        }

        for (int i = 0; i < check.size(); i++) {
            if(visit[i]) continue;
            if(cur == 0 && check.get(i) == 0) continue;
            visit[i] = true;
            recursive(cur + 1, tmp + check.get(i));
            visit[i] = false;
        }
    }
}
