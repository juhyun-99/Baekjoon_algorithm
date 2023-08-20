import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
	int x;
	int y;
	int cnt;
	int b;
	Point(int x ,int y, int cnt,int b){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.b = b;
	}
}
public class Main {
	static int n,m,ans = -1;
	static char[][] arr;
	static boolean[][][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    arr = new char[n][m];
	    visit = new boolean[2][n][m];
	    for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
	    
	    bfs();
	    System.out.println(ans);
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,1,0));
		visit[0][0][0]=true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == n - 1 && p.y == m - 1) {				
				ans = p.cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(0 <= nx && nx < n && 0<= ny && ny < m) {
					if(arr[nx][ny] == '1') {//벽일 때
						if(p.b == 0 && !visit[1][nx][ny]) { //벽 부순적 없고, 벽 부수고 방문한적 없을 때
							visit[1][nx][ny] = true;
							q.add(new Point(nx, ny, p.cnt + 1, p.b + 1));
						}
					}
					if(arr[nx][ny] == '0') { //벽 아닐때
						if(p.b == 0 && !visit[0][nx][ny]) { //벽 안부셨고, 방문한적 없을 때				
							q.add(new Point(nx, ny, p.cnt + 1, p.b));
							visit[0][nx][ny] = true;
						}
						else if(p.b == 1 && !visit[1][nx][ny]) { //벽 부순적 있는데, 방문한적 없을 때
							q.add(new Point(nx, ny, p.cnt + 1, p.b));
							visit[1][nx][ny] = true;
						}
					}
				}
			}
		}
		
		
	}
}
