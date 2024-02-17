import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans = 0;
	static boolean[] visitCol, visitLeft, visitRight;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		visitLeft =  new boolean[2 * n - 1];
		visitRight = new boolean[2 * n - 1];
		visitCol = new boolean[n];
		recursive(0);
		System.out.println(ans);
		
	}
	private static void recursive(int num) {
		if(num == n) {
			ans++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(visitLeft[num + i]) continue;
			if(visitRight[num - i  + (n - 1)]) continue;
			if(visitCol[i]) continue;
			visitLeft[num + i] = true;
			visitRight[num - i + (n-1)] = true;
			visitCol[i] = true;
			recursive(num + 1);
			visitLeft[num + i] = false;
			visitRight[num - i + (n-1)] = false;
			visitCol[i] = false;
		}
	}
}
