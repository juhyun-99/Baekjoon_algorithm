import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	int time;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(int x, int y, int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
public class Main {
	static int n, m;
	static int[][] arr;
	static List<Point> virus;
	static boolean[][] visit;
	static int sel[];
	static Queue<Point> q = new ArrayDeque<>();
	static int empty;
	static int ans = Integer.MAX_VALUE;
	static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visit = new boolean[n][n];
		// 바이러스 유출하려고함.
		// 0 빈칸 , 1 벽, 2 바이러스 놓을 수 있는 칸
		// 빈칸, 벽 = 연구소
		// 
		virus = new ArrayList<>();
		sel = new int[m];
		empty = n * n;
	    for (int i = 0; i < n; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for (int j = 0; j < n; j++) {
	    		arr[i][j] = Integer.parseInt(st.nextToken());
	    		if(arr[i][j] == 2) {
	    			virus.add(new Point(i,j));
	    		}
	    		else if(arr[i][j] == 1) empty--;
	    	}
	    }
	    empty -= m;
	    dfs(0, 0);
	    System.out.println(ans == Integer.MAX_VALUE? -1 : ans);
	}
	private static void dfs(int idx, int start) {
		if(idx == m) {
			q.clear();
			visit = new boolean[n][n];
			for (int i = 0; i < m; i++) {
				int x = virus.get(sel[i]).x;
				int y = virus.get(sel[i]).y;
				arr[x][y] = 3; //바이러스를 3으로 만듦.
				q.add(new Point(x, y, 0));
				visit[x][y] = true;
			}
			
			ans = Math.min(ans, bfs());
			//다시 되돌리기
			for (int i = 0; i < m; i++) {
				int x = virus.get(sel[i]).x;
				int y = virus.get(sel[i]).y;
				arr[x][y] = 2; 
			}
			return;
		}
		
		for (int i = start; i < virus.size(); i++) {
			sel[idx] = i;
			dfs(idx + 1, i + 1);
		}
	}
	private static int bfs() {
		int cnt = 0;
		int time = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			time = Math.max(time, p.time);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<= nx && nx < n && 0<= ny && ny < n && (arr[nx][ny] == 0 || arr[nx][ny] == 2) && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new Point(nx, ny, p.time + 1));
					cnt++;
				}
			}
		}

		if(cnt == empty) {
			return time;
		}
		return Integer.MAX_VALUE;
		
	}
}