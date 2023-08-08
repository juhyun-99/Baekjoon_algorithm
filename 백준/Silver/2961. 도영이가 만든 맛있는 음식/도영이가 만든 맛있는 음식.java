import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {
	static int N ,sin[], ssn[];
	static int sinM, ssnP, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		sin = new int[N];
		ssn = new int[N];
		
		sinM = 1;
		ssnP = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			ssn[i] = Integer.parseInt(st.nextToken());
		}
		
		ans =  Integer.MAX_VALUE;
		
		//신맛, 쓴맛, 개수
		recursive(sinM, ssnP, 0, 0);
		System.out.println(ans);
	}

	private static void recursive(int sinMul, int ssnPlus, int food, int cnt) {
		if(cnt == N) {
			if (food == 0) {
				return;
			}
			int abs = Math.abs(sinMul - ssnPlus);
			ans = Math.min(ans, abs);

			return;
		}
		recursive(sinMul*sin[cnt] , ssnPlus + ssn[cnt], food + 1, cnt + 1);
		recursive(sinMul , ssnPlus, food, cnt + 1);
	}
}
