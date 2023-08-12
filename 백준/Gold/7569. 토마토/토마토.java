import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
class Point{
	int x;
	int y;
	int z;
	int time;
	public Point(int z, int x, int y, int time) {
		this.z = z;
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class Main {
	static int[] dx = {0,1,0,-1,0,0};
	static int[] dy = {-1,0,1,0,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static int ans,n,m,h;
	static int[][][] arr;
	static int empty = 0;
	static int tomato;
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][n][m];
		tomato = h*n*m;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k] == 0) {
						tomato--;
						empty++;
					}else if(arr[i][j][k] == -1) {
						tomato--;
					}else {
						q.add(new Point(i,j,k,0));
					}
				}
			}
		}
		if(empty==0) {
			System.out.println(0);
			System.exit(0);
		}
		int day = bfs();
		System.out.println(day);
		
	}
	private static int bfs() {
		int num = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			Point p = q.poll();
			num = Math.max(num, p.time);
			for (int d = 0; d < 6; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				int nz = p.z + dz[d];
				if(0 <= nx && nx < n && 0 <= ny && ny< m && 0 <=nz && nz < h && arr[nz][nx][ny] == 0) {
					q.add(new Point(nz,nx,ny, p.time + 1));
					arr[nz][nx][ny] = 1;
					empty--;
					
				}
			}
		}
		
		if(empty == 0) {
			return num;
		}else return -1;
		
	}
}
