import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] arr;
    static int[] check;
    static int ans = Integer.MAX_VALUE;
    static int count = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];
        check = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String command = st.nextToken();
            for (int j = 0; j < m; j++) {
                if(command.charAt(j) == 'Y'){
                    arr[i][j] = true;
                }
            }
        }

        recursive(0, 0);
        ans = count == Integer.MIN_VALUE ? -1 : ans;
        System.out.println(ans);

    }

    private static void recursive(int cur, int cnt) {
        if(cur == n){
            if(cnt == 0) return;
            int tmp = 0; //칠 수 있는 음악 갯수

            for (int i = 0; i < m; i++) {
                if(check[i] > 0){
                    tmp++;
                }
            }
            if(tmp == 0) return;
            if(tmp == count){
                ans = Math.min(ans, cnt);
            }
            if(tmp > count){
                ans = cnt;
                count = tmp;
            }
            return;
        }


        //선택 안함
        recursive(cur + 1, cnt);

        //선택
        for (int i = 0; i < m; i++) {
            if(arr[cur][i]){
                check[i]++;
            }
        }

        recursive(cur + 1, cnt + 1);
        for (int i = 0; i < m; i++) {
            if(arr[cur][i]){
                check[i]--;
            }
        }
    }


}
