import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;
    int time;

    public Point(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static boolean[][] visit;
    static int ans;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n][m];
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 1));
        visit[0][0] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.x == n - 1 && p.y == m - 1){
                ans = p.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 1 && !visit[nx][ny]){
                    queue.add(new Point(nx, ny, p.time + 1));
                    visit[nx][ny] = true;
                }
            }
        }
    }

}
