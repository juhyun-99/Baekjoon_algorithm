import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n,m;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] visit;
	static int cheese = 0;
	static List<Point> cheeses;
	static int time = 0;
	static Queue<Point> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        cheeses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 1) {
        			cheese++;
        			cheeses.add(new Point(i,j));
        		}
			}
		}
        q.add(new Point(0,0));
        
        while(true) {
        	bfs();
        	//print();
        	time++;
        	for (int i = 0; i < cheeses.size(); i++) {
				Point p = cheeses.get(i);
				if(arr[p.x][p.y] == 1) {		
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = p.x + dx[d];
						int ny = p.y + dy[d];
						if(0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 2) {
							cnt++;
						}
					}
					
					if(cnt >= 2) {
						cheese--;
						q.add(new Point(p.x, p.y));
					}
				}
			}
        	if(cheese <= 0) {        		
        		break;
        	}
        }
        System.out.println(time);
    }
    
	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			arr[p.x][p.y] = 2;
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(0<= nx && nx < n && 0<= ny && ny < m && arr[nx][ny] == 0) {
					q.add(new Point(nx, ny));
					arr[nx][ny] = 2;
				}
			}
		}
		
	} 
}
