import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = 0;
            int right = n - 1;
            int ans = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int tmp = Math.abs(arr[i] - arr[j]) + arr[j];
                    ans += search(left, right, tmp);
                }
            }

            System.out.println(ans);
        }
    }
    public static int search(int left, int right, int tmp) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == tmp) {
                return 1;
            } else if (arr[mid] > tmp) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
