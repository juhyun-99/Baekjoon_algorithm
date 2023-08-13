import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visit = new boolean[26];
	static int r,c;
	static char[][] arr;
	static int ans = Integer.MIN_VALUE;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		visit[arr[0][0] - 65] = true;
		dfs(0,0,1); 
		System.out.println(ans);
	}
	private static void dfs(int i, int j, int cnt) {
		if(cnt == 26) {
			ans = 26;
			return;
		}
		
		ans = Math.max(ans, cnt);

		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if(0 <=nx && nx < r && 0 <=ny&& ny< c && !visit[arr[nx][ny] - 65]) {
				visit[arr[nx][ny] - 65] = true;
				dfs(nx, ny, cnt+1);
				visit[arr[nx][ny] - 65] = false;
			}
		}	
	}
}
