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

        st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        int check = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == x) {
                cnt++;
                check++;
            } else break;
        }

        int start = 0;
        int end = arr.length - check - 1;

        int left = 0;

        while (start <= end) {
            if (start == end) {
                left++;
                break;
            }
            long tmp = arr[start] + arr[end];

            if (tmp * 2 >= x) {
                cnt++;
                end--;
                start++;
            }
            else {
                left++;
                start++;
            }
        }

        System.out.println(cnt + left / 3);
    }
}
