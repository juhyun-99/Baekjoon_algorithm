import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class CCTV{
	int num;
	int x;
	int y;
	CCTV(int num, int x, int y){
		this.num = num;
		this.x = x;
		this.y = y;
	}
}
public class Main {
					//우 하 좌 상
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[] sel;
	static int n, m;
	static int[][] arr;
	static int[][] copy;
	static int ans = Integer.MAX_VALUE;
	static int full = 0;
	static List<CCTV> cctv = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		copy = new int[n][m];
		full = n*m;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];
				if(arr[i][j] > 0 && arr[i][j] < 6) {
					cctv.add(new CCTV(arr[i][j],i,j));
				}
				
			}
		}
		sel = new int[cctv.size()];
		recursive(0);
		System.out.println(ans);
	}
	
	private static void recursive(int idx) {
		if(idx == cctv.size()) {
			ans = Math.min(ans, check());
			return;
		}
		
		switch(cctv.get(idx).num ) {
		case 1:
			for (int i = 0; i < 4; i++) {
				sel[idx] = i;
				recursive(idx + 1);
			}break;
		case 2:
			for (int i = 0; i < 2; i++) {
				sel[idx] = i;
				recursive(idx + 1);
			}break;
		case 3:
			for (int i = 0; i < 4; i++) {
				sel[idx] = i;
				recursive(idx + 1);
			}break;
		case 4:
			for (int i = 0; i < 4; i++) {
				sel[idx] = i;
				recursive(idx + 1);
			}break;
		case 5:
			sel[idx] = 1;
			recursive(idx + 1);
			break;
		}
	}

	private static int check() {
		int cnt = 0;
		for (int i = 0; i < cctv.size(); i++) {
			CCTV cc = cctv.get(i);
			switch(cc.num) {
			case 1:
				view(cc, sel[i]);
				break;
			case 2:
				//우 하 좌 상
				view(cc, sel[i]);
				view(cc, sel[i] + 2);
				break;
			case 3:
				view(cc, sel[i]);
				view(cc, (sel[i] + 1) % 4);
				break;
			case 4:
				view(cc, (sel[i] - 1 + 4) % 4);
				view(cc, sel[i]);
				view(cc, (sel[i] + 1) % 4);
				break;
			case 5:
				for (int j = 0; j < 4; j++) {
					view(cc, j);
				}
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(copy[i][j] == 0) {
					cnt++;
				}
				copy[i][j] = arr[i][j];
			}
		}
		return cnt;
	}

	private static void view(CCTV cc, int d) {
		int nx = cc.x + dx[d];
		int ny = cc.y + dy[d];

		while(0<= nx && nx < n && 0<= ny && ny < m && copy[nx][ny] != 6) {
			copy[nx][ny] = 7;
			nx += dx[d];
			ny += dy[d];
		}

	}
}
