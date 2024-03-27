import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int tmp = arr[1];
            int ans = 1;
            for (int i = 2; i <= n; i++) {
                if(arr[i] < tmp){ //서류 심사 성적이 높은 사람 보다 면접 순위가 높을 때
                    ans++;
                    tmp = arr[i];
                }
            }
            sb.append(ans + "\n");

        }
        System.out.println(sb);


    }
}
