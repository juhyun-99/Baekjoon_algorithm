import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = 0;
//                System.out.printf(i + " " + j + "\n");
                if(arr[i][0] > arr[j][0]) tmp++;
                else if(arr[i][0] < arr[j][0]) tmp--;

                if(arr[i][1] > arr[j][1]) tmp++;
                else if(arr[i][1] < arr[j][1]) tmp--;

                if(tmp == 2) ans[j]++;
                else if(tmp == -2) ans[i]++;
//                System.out.println(Arrays.toString(ans));
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb);

    }

}