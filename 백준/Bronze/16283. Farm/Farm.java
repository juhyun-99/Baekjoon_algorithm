import java.io.*;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(stk.nextToken()); //양
		int b = Integer.parseInt(stk.nextToken()); //염소
		int n = Integer.parseInt(stk.nextToken()); //양 + 염소
		int w = Integer.parseInt(stk.nextToken()); //하루 동안 소비한 사료의 양

		int cnt = 0;
		int ans = 0;
		for(int i = 1; i <= n - 1; i ++) {
			if((a*i + b*(n-i)) == w) {
				cnt += 1;
				ans = i;
			}
		}

		if(cnt >= 2 || cnt == 0) {
			System.out.println(-1);
		}
		else {
			System.out.printf("%d %d", ans, n - ans);
		}
	}
}