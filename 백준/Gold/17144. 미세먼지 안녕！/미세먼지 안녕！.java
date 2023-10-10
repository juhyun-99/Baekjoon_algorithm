import java.io.*;
import java.util.*;

public class Main {
	static int r, c, t;
	static boolean[][] exist;
	static int[][] arr;
	static int[] dx1 = {0, -1, 0, 1};
	static int[] dy1 = {1, 0, -1, 0};
	static int[] dx2 = {0, 1, 0, -1};
	static int[] dy2 = {1, 0, -1, 0};
	static List<int[]> clear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        exist = new boolean[r][c];
        clear = new ArrayList<>();
        arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                    exist[i][j] = true;
                    clear.add(new int[]{i, j});
                }
            }
        }

        

        for (int time = 0; time < t; time++) {
            dust();
            clearDust();
        }

        int sum = 0;
        for (int[] row : arr) {
            for (int val : row) {
                sum += val;
            }
        }

        System.out.println(sum);
    }

    private static void dust() {
        int[][] arr2 = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] >= 5) {
                    int tmp = arr[i][j] / 5;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx1[d];
                        int ny = j + dy1[d];
                        if (0 <= nx && nx < r && 0 <= ny && ny < c && !exist[nx][ny]) {
                            arr2[nx][ny] += tmp;
                            arr2[i][j] -= tmp;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] += arr2[i][j];
            }
        }
    }

    private static void clearDust() {
        int d = 0;
        int x = clear.get(0)[0];
        int y = 1;
        int tmp = 0;
        while (true) {
            int nx = x + dx1[d];
            int ny = y + dy1[d];

            if (x == clear.get(0)[0] && y == 0) {
                break;
            }
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                d++;
                continue;
            }

            int temp = arr[x][y];
            arr[x][y] = tmp;
            tmp = temp;
            x = nx;
            y = ny;
        }


        d = 0;
        x = clear.get(1)[0];
        y = 1;
        tmp = 0;
        while (true) {
            int nx = x + dx2[d];
            int ny = y + dy2[d];

            if (x == clear.get(1)[0] && y == 0) {
                break;
            }
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                d++;
                continue;
            }

            int temp = arr[x][y];
            arr[x][y] = tmp;
            tmp = temp;
            x = nx;
            y = ny;
        }
    }
}
