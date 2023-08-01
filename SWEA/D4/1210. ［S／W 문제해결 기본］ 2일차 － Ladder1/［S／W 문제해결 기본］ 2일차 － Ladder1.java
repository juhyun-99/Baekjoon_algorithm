import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int[] dx = { -1, 0, 0 };
	static int[] dy = { 0, 1, -1 };


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		arr = new int[100][100];

		for (int test = 1; test <= 10; test++) {
			int t = Integer.parseInt(br.readLine());
			int startX = 0;
			int startY = 0;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}

			int nx;
			int ny;
			while (startX != 0) {
				for (int d = 0; d < 3; d++) {
					nx = startX + dx[d];
					ny = startY + dy[d];
					if (0 <= nx && nx < 100 && 0 <= ny && ny < 100 && arr[nx][ny] == 1) {
						arr[nx][ny] = -1;
						startX = nx;
						startY = ny;
					}
				}

			}
			
			sb.append("#" + test + " " + startY + "\n");
		}
		System.out.println(sb);

	}
}
