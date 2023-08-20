import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class Point{
	int x ;
	int y;
	Point(int x ,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
	
	static int[] kdx = {2, 2, 1, 1, -1, -1, -2, -2};
	static int[] kdy = {1, -1, 2, -2, 2, -2, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	   
	    List<Point> queen = new ArrayList<>();
	    List<Point> knight = new ArrayList<>();
	    int[][] visit = new int[n][m];
	    st = new StringTokenizer(br.readLine());
	    
	    int k = Integer.parseInt(st.nextToken());
	    for (int i = 0; i < k; i++) {
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			queen.add(new Point(x, y));
			visit[x][y] = 1;
		}
	    
	    st = new StringTokenizer(br.readLine());
	    k = Integer.parseInt(st.nextToken());
	    for (int i = 0; i < k; i++) {
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			knight.add(new Point(x, y));
			visit[x][y] = 2;
		}
	    
	    st = new StringTokenizer(br.readLine());
	    k = Integer.parseInt(st.nextToken());
	    for (int i = 0; i < k; i++) {
			visit[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 3;
		}
	    
	    for (int i = 0; i < queen.size(); i++) {
	    	int x = queen.get(i).x;
	    	int y = queen.get(i).y;
			for (int j = 0; j < 8; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				while(0 <=nx && nx < n && 0<= ny && ny < m && (visit[nx][ny] == 0 || visit[nx][ny] == 1)) {
					visit[nx][ny] = 1;
					nx += dx[j];
					ny += dy[j];
				}
			}
		}
	    
	    
	    for (int i = 0; i < knight.size(); i++) {
	    	int x = knight.get(i).x;
	    	int y = knight.get(i).y;
			for (int j = 0; j < 8; j++) {
				int nx = x + kdx[j];
				int ny = y + kdy[j];
				if(0 <=nx && nx < n && 0<= ny && ny < m && visit[nx][ny] == 0) {
					visit[nx][ny] = 2;
				}
			}
		}
	    

	    
	    
	    int ans = 0;
	    for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(visit[i][j] == 0) {
					ans++;
				}
			}
		}
	    
	    System.out.println(ans);
	}
}
