import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //               0 동 서 북 남
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    static int n, m, x, y, k;
    static int[][] arr;
    static int ewArr[] = new int[]{0, 0, 0, 0};
    static int nsArr[] = new int[]{0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            move(d);
            if(arr[nx][ny] == 0) {
                arr[nx][ny] = ewArr[3];
            }
            else {
                ewArr[3] = arr[nx][ny];
                nsArr[3] = ewArr[3];
                arr[nx][ny] = 0;
            }
            x = nx; y = ny;
            sb.append(ewArr[1] + "\n");
        }
        System.out.print(sb);
    }

    private static void move(int d) {
        int tmp;
        if(d == 1){ //동쪽 이면
            tmp = ewArr[3];
            for (int i = 3; i > 0; i--) {
                ewArr[i] = ewArr[i - 1];
            }
            ewArr[0] = tmp;
            for (int i = 1; i < 4; i+=2) {
                nsArr[i] = ewArr[i];
            }
        }
        else if (d == 2) { // 서
            tmp = ewArr[0];
            for (int i = 0; i < 3; i++) {
                ewArr[i] = ewArr[i + 1];
            }
            ewArr[3] = tmp;
            for (int i = 1; i < 4; i+=2) {
                nsArr[i] = ewArr[i];
            }
        }
        else if (d == 3) { //남
            tmp = nsArr[3];
            for (int i = 3; i > 0; i--) {
                nsArr[i] = nsArr[i - 1];
            }
            nsArr[0] = tmp;
            for (int i = 1; i < 4; i+=2) {
                ewArr[i] = nsArr[i];
            }
        }

        else{ // 북
            tmp = nsArr[0];
            for (int i = 0; i < 3; i++) {
                nsArr[i] = nsArr[i + 1];
            }
            nsArr[3] = tmp;
            for (int i = 1; i < 4; i+=2) {
                ewArr[i] = nsArr[i];
            }
        }
    }
}
