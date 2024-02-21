import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr, arr2;
    static boolean[] visit;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[3][3];
        arr2 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[10];
        recursive(0,0,0); // x, y, 비용
        System.out.println(ans);
    }

    private static void recursive(int x, int y, int total) {
        if(y == 3){ //끝 열일 때 다음 행
            x += 1;
            y = 0;
        }

        if(x == 3){ // 모든 행을 다 봤을 때
            if(check()) ans = Math.min(ans, total);
            return;
        }

        for (int i = 1; i < 10; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            arr2[x][y] = i;
            recursive(x, y + 1, total + Math.abs(arr[x][y] - i));
            visit[i] = false;
            arr2[x][y] = 0;
        }
    }

    private static boolean check() {
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += arr2[i][j];
            }
            if(sum != 15) return false;
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += arr2[j][i];
            }
            if(sum != 15) return false;
        }

        if(arr2[0][0] + arr2[1][1] + arr2[2][2] != 15) return false;
        if(arr2[2][0] + arr2[1][1] + arr2[0][2] != 15) return false;


        return true;
    }
}
