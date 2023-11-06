import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr;
	static int n, k;
	static int answer;
	static int[] dx = {0,0,1};
	static int[] dy = {0,1,0};
	static int[][][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			answer = 0;
			arr = new char[n][n];
			dp = new int[k + 2][n][n][3];
			for (int i = 0; i < k + 2; i++) {
				for (int j = 0; j < n; j++) {
					for (int j2 = 0; j2 < n; j2++) {
						for (int k = 0; k < 3; k++) {
							dp[i][j][j2][k] = -1;
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			recursive(0,0,0,0);
			sb.append(dp[0][0][0][0]+ "\n");
		}
		System.out.println(sb);
 	}
	private static int recursive(int cnt, int x, int y, int d) {
		int ret = 0;
		if(cnt > k + 1) return 0;
		if(x == n - 1 && y == n - 1 ) {
			return 1;
		}
		if(dp[cnt][x][y][d] != -1) return dp[cnt][x][y][d];
		
		for (int i = 1; i <= 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] == '.' ) {
				if(d == i) {
					ret += recursive(cnt, nx, ny, i);
				}
				else {
					ret += recursive(cnt + 1, nx, ny, i);
				}
			}
		}

		return  dp[cnt][x][y][d] = ret;
	}
}
