import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point {
    int x;
    int y;
    int day;

    Point(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
public class Main {
    static int m, n;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int tomato = 0;
    static boolean[][] visit;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        int plus = 0;
        int minus = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    minus++;
                } else if (arr[i][j] == 1) {
                    q.add(new Point(i, j, 0));
                    plus++;
                } else tomato++;
            }
        }

        if (plus + minus == n * m) {
            System.out.println(0);
            System.exit(0);
        }


        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    tomato--;
                    q.add(new Point(nx, ny, p.day + 1));
                    if (tomato == 0) {
                        return p.day + 1;
                    }
                }
            }
        }
        return -1;
    }
}
