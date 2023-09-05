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
	int d;
	int cnt;

	Point(int x, int y, int d, int cnt){
		this.x = x;
		this.y = y;
		this.d = d;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", d=" + d + ", cnt=" + cnt + "]";
	}
	
	
}
public class Main {
	static int m,n;
	static int[][] arr;
	//동 남 서 북
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][][] visit;
	static int startX, startY, startD, endX, endY, endD;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		visit = new boolean[m][n][4];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken())-1;
		startY = Integer.parseInt(st.nextToken())-1;
		startD = Integer.parseInt(st.nextToken());
		switch(startD) {
		case 1: startD = 0; break;
		case 2: startD = 2; break;
		case 3: startD = 1; break;
		case 4: startD = 3; break;
		}
		
		st = new StringTokenizer(br.readLine());
		endX = Integer.parseInt(st.nextToken())-1;
		endY = Integer.parseInt(st.nextToken())-1;
		endD = Integer.parseInt(st.nextToken());
		switch(endD) {
		case 1: endD = 0; break;
		case 2: endD = 2; break;
		case 3: endD = 1; break;
		case 4: endD = 3; break;
		}
		
		bfs();
	}
	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(startX, startY, startD, 0));
		visit[startX][startY][startD] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			//System.out.println(p.toString());
			if(p.x == endX && p.y == endY && p.d == endD) {//좌표에 도착했을 때
				System.out.println(p.cnt);
				break;
			}
			//현재 방향에서 앞으로 3칸까지 가보기
			for (int i = 1; i <= 3; i++) {
				int nx = p.x + dx[p.d] * i;
				int ny = p.y + dy[p.d] * i;
				if(0<= nx && nx < m && 0<= ny && ny < n) {
					if(visit[nx][ny][p.d]) continue;
					if(arr[nx][ny] == 0) {
						q.add(new Point(nx, ny, p.d, p.cnt + 1));
						visit[nx][ny][p.d] = true;
					}else 
						break;
				}
				
			}
			//방향 전환
			for (int i = 0; i < 4; i++) {
				if(i == p.d) continue;
				if(!visit[p.x][p.y][i]) {
					//방향전환만 해서 넣어준다.
					if(Math.abs(p.d - i) == 2) {
						q.add(new Point(p.x, p.y, i, p.cnt + 2));
					}else {
						q.add(new Point(p.x, p.y, i, p.cnt + 1)); 
					}
					visit[p.x][p.y][i] = true;
				}
			}
		}
	}
}
