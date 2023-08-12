import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, cnt = 0, sum = 0;
	static char[][] arr;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == '1' ) {
					arr[i][j] ='0';
					list.add(bfs(i,j));
					cnt+=1;
				}
			}
		}
		sb.append(cnt + "\n");
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb);
	}
	
	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		int sum = 0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			sum++;
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(0 <= nx && nx < n && 0<= ny && ny < n  && arr[nx][ny] == '1') {
					q.add(new int[] {nx, ny});
					arr[nx][ny] = '0';
				}
			}
		}
		return sum;
	}
}
