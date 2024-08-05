import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] sum = new int[m];
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp += arr[j][i];
            }
            sum[i] = tmp;
        }
        int a = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < a; i++) {
            ans += sum[i];
        }
        int left = 0;
        int right = a;
        int calc = ans;
        while(right < m){
            calc -= sum[left];
            calc += sum[right];

            ans = Math.max(ans, calc);
            left++;
            right++;
        }
        System.out.println(ans);


    }
}
