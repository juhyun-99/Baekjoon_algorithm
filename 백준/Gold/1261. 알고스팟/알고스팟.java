import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point>{
    int x;
    int y;
    int time;

    public Point(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo(Point o) {
        return this.time - o.time;
    }
}
public class Main {
    static int n, m;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        dijkstra();
        System.out.println(visit[n - 1][m - 1]);
    }

    private static void dijkstra() {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0, 0));
        visit[0][0] = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx & nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == '1') {
                        if(visit[nx][ny] > p.time + 1){
                            q.add(new Point(nx, ny, p.time + 1));
                            visit[nx][ny] = p.time + 1;
                        }

                    } else {
                        if(visit[nx][ny] > p.time){
                            q.add(new Point(nx, ny, p.time));
                            visit[nx][ny] = p.time;
                        }
                    }
                }
            }
        }

    }
}
