import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, n;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int tomato = 0;
	static boolean[][] visit;
	static Queue<Point> Q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];
		int plus = 0;
		int minus = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					minus++;
				}
				else if(arr[i][j] == 1) {
					Q.add(new Point(i, j, 0));
					plus++;
				}
				else tomato++;
			}
		}
		
		if(plus + minus == n * m) {
			System.out.println(0);
			System.exit(0);
		}

		
		System.out.println(bfs());
	}
	
	static class Point{
		int x;
		int y;
		int day;
		Point(int x, int y, int day){
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	private static int bfs() {
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					tomato--;
					Q.add(new Point(nx,ny, p.day + 1));
					if(tomato == 0) {
						return p.day + 1;
					}
				}
			}
		}
		return -1;
		
	}
}
