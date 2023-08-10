import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    static int n,m;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = new int[] {1,-1,0,0};
    static int[] dy = new int[] {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dist = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<m; j++) {
                arr[i][j] = str.charAt(j)-'0';
                if(i==0&&j==0) dist[i][j]=1;
            }
        }

        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(0,0));

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int dir=0; dir<4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx >=0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1 && dist[nx][ny] == 0){
                    dist[nx][ny] = dist[cur.x][cur.y]+1;
                    q.offer(new Point(nx,ny));
                }
            }
        }

        System.out.println(dist[n-1][m-1]);
    }
}