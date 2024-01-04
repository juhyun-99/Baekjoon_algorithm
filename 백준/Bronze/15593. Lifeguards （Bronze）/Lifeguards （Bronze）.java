import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] time = new int[1001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            for (int j = arr[i][0]; j < arr[i][1]; j++) {
                time[j] += 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i][0]; j < arr[i][1]; j++) {
                time[j] -= 1;
            }
            int cnt = 0;
            for (int j = 0; j < 1001; j++) {
                if(time[j] > 0) cnt++;
            }

            for (int j = arr[i][0]; j < arr[i][1]; j++) {
                time[j] += 1;
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}