import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
	int x;
	int y;
	int cnt;
	int hcnt;
	Point(int x, int y, int cnt, int hcnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.hcnt = hcnt;
	}
}
public class Main {
	static int k, w, h;
	static List<Integer>[] edges;
	static int[][] arr;
	static boolean[][][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int ans = Integer.MAX_VALUE;
	static int[] hdx = {1,-1,1,-1,2,-2,2,-2};
	static int[] hdy = {2,2,-2,-2,1,1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        visit = new boolean[k + 1][h][w];
        
        for (int i = 0; i < h; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}    
        bfs();
        System.out.println(ans == Integer.MAX_VALUE? -1 : ans);
    }
    
	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(0,0,0,0));
		visit[0][0][0] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			if(x == h - 1 && y == w - 1) {
				ans = p.cnt;
				break;
			}
			
			if(p.hcnt + 1 <= k) {				
				for (int i = 0; i < 8; i++) {
					int nx = x + hdx[i];
					int ny = y + hdy[i];
					if(0<= nx && nx < h && 0<= ny && ny < w && arr[nx][ny] == 0 && !visit[p.hcnt + 1][nx][ny]) {
						q.add(new Point(nx, ny, p.cnt + 1, p.hcnt + 1));
						visit[p.hcnt + 1][nx][ny] = true;					
					}
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<= nx && nx < h && 0<= ny && ny < w && arr[nx][ny] == 0 && !visit[p.hcnt][nx][ny]) {
					q.add(new Point(nx, ny, p.cnt + 1, p.hcnt));
					visit[p.hcnt][nx][ny] = true;					
				}
			}
		}
	}
        
    
}