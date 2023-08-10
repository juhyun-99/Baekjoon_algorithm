import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,m;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = new int[] {1,-1,0,0};
    static int[] dy = new int[] {0,0,1,-1};
    static List<Point> list;
    static Queue<Point> q;
    static Queue<Point> copyQ;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        q = new LinkedList<>();
        copyQ = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        ans = Integer.MIN_VALUE;

        //입력받기
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j]==0) {
                    list.add(new Point(i,j));
                }
                if(arr[i][j]==2) {
                    q.offer(new Point(i,j));
                }

            }
        }

        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                for(int k=j+1; k<list.size(); k++) {
                    visit = new boolean[n][m];

                    arr[list.get(i).x][list.get(i).y] = 1;
                    arr[list.get(j).x][list.get(j).y] = 1;
                    arr[list.get(k).x][list.get(k).y] = 1;

                    for(int m=0; m<q.size(); m++) {
                        Point tmp = q.poll();
                        copyQ.offer(tmp);
                        q.offer(tmp);
                    }
                    ans = Math.max(ans, list.size()-3-bfs());

                    arr[list.get(i).x][list.get(i).y] = 0;
                    arr[list.get(j).x][list.get(j).y] = 0;
                    arr[list.get(k).x][list.get(k).y] = 0;
                }
            }
        }
        System.out.println(ans);
    }

    private static int bfs() {
        int cnt=0;
        while(!copyQ.isEmpty()) {
            Point cur = copyQ.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int dir=0; dir<4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny]==0 && !visit[nx][ny]) {
                    cnt++;
                    visit[nx][ny] = true;
                    copyQ.offer(new Point(nx,ny));
                }
            }
        }
        return cnt;
    }
}
