import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
	int x; 
	int y;
	int cnt; //다리길이
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
	}
	
}
public class Main {
	static int n;
	static int[] dx = {0,-1,0,1}, dy = {1,0,-1,0};
	static int[][] arr;
	static boolean[][] visit;
	static int num = 1;
	static Queue<Point> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//섬 번호 넘버링
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j] && arr[i][j] == 1) {
					visit[i][j] = true;
					arr[i][j] = num;
					bfs(i,j);
					num++; //1번부터 해줌
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] > 0) {
					visit = new boolean[n][n];
					ans = Math.min(ans, checkDist(i,j));
				}
			}
		}

		System.out.println(ans);
	}
	
	private static int checkDist(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i,j));
		int num = arr[i][j]; //섬번호
		int number = 0;
		visit[i][j] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int m = 0; m < size; m++) {				
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(0<= nx && nx < n && 0<= ny && ny < n && !visit[nx][ny]){
						if(arr[nx][ny] == 0) {
							q.add(new Point(nx, ny));
							visit[nx][ny] = true;
						}
						else if(arr[nx][ny] != num){
							return number;
						}
					}
				}
			}
			number++;
		}
	
		return Integer.MAX_VALUE;
	}

	
	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i,j));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(0<= nx && nx < n && 0<= ny && ny < n && !visit[nx][ny] && arr[nx][ny] == 1) {
					arr[nx][ny] = num;
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
	}
}
