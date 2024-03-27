import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
    static int ans = 0;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n][m];
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 'L'){
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int x, int y) {
        visit = new boolean[n][m];
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y, 0));
        visit[x][y] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            ans = Math.max(ans, p.time);

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 'L' && !visit[nx][ny]){
                    queue.add(new Point(nx, ny, p.time + 1));
                    visit[nx][ny] = true;
                }
            }
        }
    }

}
