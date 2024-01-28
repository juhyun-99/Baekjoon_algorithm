import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] h = new int[n + 1];
        int[] s = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            char cmd = br.readLine().charAt(0);
            switch (cmd){
                case 'H':
                    h[i] = h[i - 1] + 1;
                    s[i] = s[i - 1];
                    p[i] = p[i - 1];
                    break;
                case 'S':
                    h[i] = h[i - 1];
                    s[i] = s[i - 1] + 1;
                    p[i] = p[i - 1];
                    break;
                case 'P':
                    h[i] = h[i - 1];
                    s[i] = s[i - 1];
                    p[i] = p[i - 1] + 1;
                    break;
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, h[i] + s[n] - s[i]);
            ans = Math.max(h[i] + p[n] - p[i], ans);
            ans = Math.max(s[i] + h[n] - h[i],ans);
            ans = Math.max(s[i] + p[n] - p[i], ans);
            ans = Math.max(p[i] + h[n] - h[i], ans);
            ans = Math.max(p[i] + s[n] - s[i], ans);
        }
        System.out.println(ans);
    }
}
