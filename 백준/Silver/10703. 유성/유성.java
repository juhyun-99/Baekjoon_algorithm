import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
	    int r = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		char[][] arr = new char[r][s];
		char[][] ans = new char[r][s];

		List<Point> usungs = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < s; j++) {
				if(arr[i][j] == 'X') {
					ans[i][j] = '.';
					usungs.add(new Point(i,j));
				}
				else if(arr[i][j] == '#') {
					ans[i][j] = '#';
				}
				else {					
					ans[i][j] = '.';
				}
			}
		}
		
		int dist = Integer.MAX_VALUE;
		for (int i = 0; i < s; i++) {
			int usung = -1;
			for (int j = 0; j < r; j++) {
				if(arr[j][i] == 'X') {
					usung = Math.max(usung, j);
				}
				else if(arr[j][i] == '#') {
					if(usung != -1) {				
						dist = Math.min(dist, j - usung - 1);
						//System.out.printf("%d %d %d\n",i, j, usung);			
					}
				}
			}
		}
		
		//System.out.println(dist);
		for (int i = 0; i < usungs.size(); i++) {
			int x = usungs.get(i).x;
			int y = usungs.get(i).y;
			ans[x + dist][y] = 'X';
		}
		
		for (int i = 0; i < r; i++) {
			sb.append(new String(ans[i]) + "\n");
		}
		
		System.out.println(sb);
	}
}
