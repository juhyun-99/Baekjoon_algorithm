import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[n];
        prefix[0] = arr[0];
        int ans = prefix[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1] + arr[i], arr[i]);
            ans = Math.max(prefix[i], ans);
        }
        System.out.println(ans);
    }
}
