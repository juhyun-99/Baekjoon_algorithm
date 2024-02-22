import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m, k;
    static int[] sel;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        /*
        * n개만 빼고 모두 망가뜨림
        * 2n개의 스킬을 n개에 적절히 배치해서 퀘스트
        *
        * m개의 퀘스트는 각각 k개의 스킬을 사용해야함 - 스킬 못쓰면 퀘스트 못함
        *
        * */
        arr = new int[m][k];
        sel = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 1);
        System.out.println(ans);

    }

    private static void recursive(int cur, int start) {
        if(cur == n){
            //System.out.println(Arrays.toString(sel));
            int cnt = 0;
            int[] check = new int[m];
            for (int i = 0; i < n; i++) { //10

                for (int j = 0; j < m; j++) { //100
                    for (int l = 0; l < k; l++) { //10
                        if(sel[i] == arr[j][l]){
                            check[j]++;
                            if(check[j] == k) cnt++;
                            break;
                        }
                    }
                }
            }
            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = start; i <= 2 * n; i++) {
            sel[cur] = i;
            recursive(cur + 1, i + 1);
        }
    }
}
