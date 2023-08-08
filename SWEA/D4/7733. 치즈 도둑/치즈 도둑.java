import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;
    static boolean[][] visit;
    static int n, ans;
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test <= t; test++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < n; y++) {
                    arr[x][y] = Integer.parseInt(st.nextToken());
                }
            }
             
            ans = 1;
            for (int i = 1; i <= 100 ; i++) {//1~100일까지
                visit = new boolean[n][n];
                int tmp = 0;
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        if(arr[x][y] > i  && !visit[x][y]) {
                            visit[x][y] = true;
                            bfs(x,y,i);
                            tmp++;
                        }
                    }
                }
         
               ans = Math.max(ans, tmp);
            }
            sb.append("#" + test + " " + ans + "\n");
        }
        System.out.println(sb);
    }
     
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
     
    private static void bfs(int x, int y, int day) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
         
        while(!Q.isEmpty()) {
            Point p = Q.poll();
             
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i]; 
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny] && arr[nx][ny] > day) {
                    visit[nx][ny] = true;
                    Q.add(new Point(nx, ny));
                }
            }
        }
    }
}