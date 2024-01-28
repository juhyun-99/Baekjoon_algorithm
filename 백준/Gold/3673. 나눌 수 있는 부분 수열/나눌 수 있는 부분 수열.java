import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());
        long[] prefix;
        int[] arr;
        int[] mod;
        for (int tc = 0; tc < c; tc++) {
            st = new StringTokenizer(br.readLine());
            long d = Long.parseLong(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            arr = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            prefix = new long[n + 1];
            mod = new int[(int)d];
            int cnt = 0;

            for (int i = 1; i < n + 1; i++) {
                prefix[i] = prefix[i - 1] + arr[i];
                if(prefix[i] % d == 0) cnt++;
                cnt += mod[(int)(prefix[i] % d)];
                mod[(int)(prefix[i] % d)]++;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);

    }
}
