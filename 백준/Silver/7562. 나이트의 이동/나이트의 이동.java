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
    static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    static int n, startX, startY, endX, endY;
    static int ans;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            n = Integer.parseInt(br.readLine());
            visit = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            bfs(startX, startY);
            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y, 0));

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == endX && p.y == endY){
                ans = p.time;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n && !visit[nx][ny]){
                    q.add(new Point(nx, ny, p.time + 1));
                    visit[nx][ny] = true;
                }
            }
        }
    }

}
