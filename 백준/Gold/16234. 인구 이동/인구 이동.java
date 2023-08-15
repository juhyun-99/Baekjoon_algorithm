import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,l,r;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean tf;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			tf = false;
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!visit[i][j]) {
						visit[i][j] = true;
						bfs(i,j);
					}
				}
			}
			//print();
			if(!tf) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}
	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();
		int sum = 0;
		q.add(new int[] {x, y});
		list.add(new int[] {x, y});
		sum += arr[x][y];
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(0 <= nx && nx < n && 0 <=ny && ny < n && !visit[nx][ny] 
						&& Math.abs(arr[tmp[0]][tmp[1]] - arr[nx][ny]) >= l &&Math.abs(arr[tmp[0]][tmp[1]] - arr[nx][ny]) <= r) {
					visit[nx][ny] = true;
					tf = true;
					q.add(new int[] {nx, ny});
					list.add(new int[] {nx, ny});
					sum += arr[nx][ny];
				}
			}
		}
		int avg = sum / list.size();
		for (int i = 0; i < list.size(); i++) {
			int[] tmp = list.get(i);
			arr[tmp[0]][tmp[1]] = avg;
		}
	}
}
