import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Vertex implements Comparable<Vertex>{
	int from;
	int to;
	int w;
	Vertex(int from, int to, int w){
		this.from = from;
		this.to = to;
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "Vertex [from=" + from + ", to=" + to + ", w=" + w + "]";
	}

	@Override
	public int compareTo(Vertex o) {
		return this.w - o.w;
	}
	
}
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
	static int n, m;
	static int[] dx = {0,-1,0,1}, dy = {1,0,-1,0};
	static int[][] arr;
	static boolean[][] visit;
	static int num = 1;
	static Queue<Point> queue = new LinkedList<>();
	static PriorityQueue<Vertex> edges = new PriorityQueue<Vertex>();
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//섬 번호 넘버링
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visit[i][j] && arr[i][j] == 1) {
					visit[i][j] = true;
					arr[i][j] = num;
					bfs(i,j);
					num++; //1번부터 해줌
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] > 0) {
					visit = new boolean[n][m];
					checkDist(i,j);
				}
			}
		}
		
		parents = new int[num];
		for (int i = 0; i < num; i++) {
			parents[i] = i;
		}
		
		int ans = kruscal();
		int aRoot = find(1);
		for (int i = 2; i < num ; i++) {
			if(aRoot != find(i)) {
				ans = -1;
				break;
			}
		}
		System.out.println(ans);
	}
	
	private static int kruscal() {
		int ans = 0;
		int cnt = 0;
		while(!edges.isEmpty()) {
			Vertex v = edges.poll();
			//System.out.println(v.toString());
			int from = v.from;
			int to = v.to;
			int w = v.w;
			if(union(from, to)) {				
				//System.out.println(v.toString());
				ans += w;
				cnt++;
			}
			if(cnt == num - 1) break;
		}
		return ans;
	}

	private static boolean union(int from, int to) {
		int aRoot = find(from);
		int bRoot = find(to);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	private static void checkDist(int i, int j) {
		int num = arr[i][j]; //섬번호
		visit[i][j] = true;
		for (int k = 0; k < 4; k++) {
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(i,j,0));
			while(!q.isEmpty()) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<= nx && nx < n && 0<= ny && ny < m && !visit[nx][ny] && arr[nx][ny] != num){
					if(arr[nx][ny] == 0) {
						q.add(new Point(nx, ny, p.cnt + 1));
						visit[nx][ny] = true;
					}
					else if(arr[nx][ny] > num && p.cnt > 1){
						//System.out.println("from " + num + " x y : " + i+ " " + j + " to " + arr[nx][ny] +" nx ny : "+ nx +" " + ny +" dist " + p.cnt + " direct " + k);
						edges.add(new Vertex(num, arr[nx][ny], p.cnt));
					}
				}					
				
			}
		}	

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
				if(0<= nx && nx < n && 0<= ny && ny < m && !visit[nx][ny] && arr[nx][ny] == 1) {
					arr[nx][ny] = num;
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
	}
}
