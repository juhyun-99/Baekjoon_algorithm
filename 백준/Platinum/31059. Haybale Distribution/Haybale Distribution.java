import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);

        int q = Integer.parseInt(br.readLine());
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = x[i - 1] + sum[i - 1];
        }

        //System.out.println(Arrays.toString(sum));
        List<Integer> setX = new ArrayList<>();
        setX.add(0);
        for (int i = 1; i < n; ++i) {
            if (x[i] > x[i - 1]) {
                setX.add(i);
            }
        }
        //System.out.println(setX.toString());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = setX.size() - 1;

            while (left < right) {
                int mid = (left + right) / 2;
                if (cal(a, b, setX, x, sum, mid) < cal(a, b, setX, x, sum, mid + 1)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            bw.write(cal(a, b, setX, x, sum, left) + "\n");
        }

        br.close();
        bw.close();
    }

    private static long cal(int a, int b, List<Integer> setX, int[] x, long[] sum, int idx) {
        int i = setX.get(idx);
        long ans = a * ((long) i * x[i] - sum[i]); //왼쪽
        ans += b * (sum[sum.length - 1] - sum[i] - (long) (x.length - i) * x[i]); //오른쪽

        return ans;
    }
}
