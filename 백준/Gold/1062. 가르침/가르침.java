import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n, k;
    static boolean[] visit;
    static String[] str;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(k < 5) {
            System.out.println("0");
            return;
        }
        str = new String[n];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            str[i] = tmp.substring(4, tmp.length() - 4);
        }

        visit = new boolean[26];
        visit['a' - 'a'] = true;
        visit['c' - 'a'] = true;
        visit['n' - 'a'] = true;
        visit['t' - 'a'] = true;
        visit['i' - 'a'] = true;

        recursive(0, 0);
        System.out.println(answer);
    }

    private static void recursive(int cur, int idx) {
        if(cur == k - 5){
            int cnt = 0;
            for (int i = 0; i < str.length; i++) {
                boolean tf = true;
                for (int j = 0; j < str[i].length(); j++) {
                    if(!visit[str[i].charAt(j) - 'a']){
                        tf = false;
                        break;
                    }
                }
                if(tf) cnt++;
            }
            answer = Math.max(cnt, answer);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            recursive(cur + 1, i + 1);
            visit[i] = false;
        }
    }
}