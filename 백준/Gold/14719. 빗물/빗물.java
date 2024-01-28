import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w + 1];
        int ans = 0;
        int[] prefix = new int[w + 1];
        int[] suffix = new int[w + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < w + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i < w + 1; i++) {
            prefix[i] = Math.max(arr[i - 1], prefix[i - 1]);
        }

        for (int i = w - 1; i > 0; i--) {
            suffix[i] = Math.max(suffix[i + 1] , arr[i + 1]);
        }

        for (int i = 2; i < w; i++) { //처음 끝 제외
            int tmp = Math.min(prefix[i], suffix[i]) - arr[i];
            if(tmp <= 0) continue;
            ans += tmp;
        }
        System.out.println(ans);

    }
}
