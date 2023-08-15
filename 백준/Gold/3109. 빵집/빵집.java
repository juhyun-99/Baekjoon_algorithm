import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//우상, 우, 우하
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	static int r, c;
	static char[][] arr;
	static boolean tf;
	static int cnt = 0;
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

		for (int i = 0; i < r; i++) {
			tf = false;
			dfs(i,0);
			//print(arr);
			if(tf) cnt++;
		}
		System.out.println(cnt);
		
	}
	private static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	private static void dfs(int x, int y) {
		if(tf) {
			arr[x][y] = '.';
			return;
		}
		if(y == c-1 && !tf) {
			tf = true;
			arr[x][y] = 'o';
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < r && 0 <=ny && ny < c && arr[nx][ny] == '.') {
				//System.out.printf("%d %d %c\n",nx, ny, arr[nx][ny]);
				arr[nx][ny] = 'o';
				dfs(nx, ny);
			}
		}
		
	}
}
