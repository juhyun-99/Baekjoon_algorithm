import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
	int x;
	int y;
	int time;
	Point(int x, int y, int time){
		this.x =x;
		this.y = y;
		this.time = time;
	}
}
public class Main {
	static char[][] arr;
	static int n, m;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int ans = Integer.MIN_VALUE;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == 'L') {
					ans = Math.max(ans, bfs(i,j));
				}
			}
		}
		System.out.println(ans);
		
	}
	private static int bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i,j,0));
		boolean[][] visit = new boolean[n][m];
		int tmp = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			Point p = q.poll();
			visit[p.x][p.y] = true;
			tmp = Math.max(tmp,p.time);
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(0<= nx && nx < n && 0<= ny && ny < m && !visit[nx][ny] && arr[nx][ny] == 'L') {
					visit[nx][ny] = true;
					q.add(new Point(nx,ny, p.time + 1));
				}
				
			}
		}
		return tmp;
	}
}
