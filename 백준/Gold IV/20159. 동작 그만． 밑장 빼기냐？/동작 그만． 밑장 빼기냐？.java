import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] me = new int[n + 1]; //정훈이
        int[] you = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                me[i] = me[i - 1] + arr[i];
                you[i] = you[i - 1];
            } else {
                you[i] = you[i - 1] + arr[i];
                me[i] = me[i - 1];
            }
        }

        int ans = me[n];

        for (int i = 1; i <= n; i++) {//밑장 빼기랑 비교
            if (i % 2 == 1) {
                ans = Math.max(ans, me[i - 1] + (you[n] - you[i]));
            } else {
                ans = Math.max(ans, me[i] + (you[n - 1] - you[i - 1]));
            }
            //System.out.println(ans);
        }

        System.out.println(ans);
    }
}
