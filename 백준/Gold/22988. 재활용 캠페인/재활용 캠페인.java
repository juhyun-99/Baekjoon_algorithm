import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        int length = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == x) {
                cnt++;
                length--;
            } else {
                break;
            }
        }

        int s = 0, e = length - 1;
        int left = 0;

        while (s <= e) {
            if (s == e) {
                left++;
                break;
            }
            long tmp = arr[s] + arr[e];
            if (tmp * 2 >= x) {
                e--;
                s++;
                cnt++;
            } else {
                left++;
                s++;
            }
        }

        System.out.println(cnt + left / 3);
    }
}
