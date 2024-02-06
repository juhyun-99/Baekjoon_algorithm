import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] hi, arc;
    static long hiWin, arcWin, draw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        hi = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hi[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hi);

        arc = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arc[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arc);

       for (int score : hi) {
            int lower = lowerBound(score);
            int upper = upperBound(score);
            int same = upper - lower;

            draw += same;
            hiWin += (upper - same);
            arcWin += (m - upper);
        }

        sb.append(hiWin).append(" ").append(arcWin).append(" ").append(draw).append("\n");
        System.out.print(sb);
    }

    public static int lowerBound(int score) {
        int ans = m;
        int start = 0;
        int end = m - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arc[mid] >= score) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int score) {
        int ans = m;
        int start = 0;
        int end = m - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arc[mid] > score) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
