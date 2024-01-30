import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st =new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] brr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        TreeMap<Long, Long> map1 = new TreeMap<>();
        TreeMap<Long, Long> map2 = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                map1.put(sum, map1.getOrDefault(sum, (long)0) + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += brr[j];
                map2.put(sum, map2.getOrDefault(sum, (long)0) + 1);
            }
        }

        long ans = 0;
        for (Long key : map1.keySet()) {
            if (map2.containsKey(t - key)) {
                ans += map1.get(key) * map2.get(t - key);
            }
        }
        System.out.println(ans);

    }
}
