import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[9][9];
	static List<int[]> zero = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = s.charAt(j) -'0';
				if(arr[i][j] == 0) {
					zero.add(new int[] {i,j});
				}
			}
		}
		
		recursive(0);
        
        
       
    }
	private static void recursive(int idx) {
		if(idx == zero.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		boolean[] visit = new boolean[10];
		

		int x = zero.get(idx)[0];
		int y = zero.get(idx)[1];
		//가로
		for (int i = 0; i < 9; i++) {
			visit[arr[x][i]] = true;
		}
		//세로
		for (int i = 0; i < 9; i++) {
			visit[arr[i][y]] = true;
		}
		//사각형
		int nx = x/3;
		int ny = y/3;
		for (int i = nx*3; i <nx*3 + 3 ; i++) {
			for (int j = ny * 3; j <ny * 3 + 3 ; j++) {
				visit[arr[i][j]] = true;
			}
		}
		
		for (int i = 1; i < 10; i++) {
			if(!visit[i]) {
				arr[x][y] = i;
				recursive(idx + 1);
				arr[x][y] = 0;
			}
		}
	}
	
}
