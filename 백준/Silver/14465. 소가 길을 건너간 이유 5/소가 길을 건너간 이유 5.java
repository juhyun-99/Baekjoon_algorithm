import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = 0;

        boolean[] check = new boolean[n + 1];
        Arrays.fill(check, true);
        for (int i = 0; i < b; i++) {
            check[Integer.parseInt(br.readLine())] = false;
        }

        for (int i = 1; i < 1 + k; i++) {
            if(!check[i]) ans++;
        }
        int cnt = ans;

        int start = 1;
        int end = k;
        while(end < n){
            if(!check[start++]) cnt--;
            if(!check[++end]) cnt++;
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }
}
