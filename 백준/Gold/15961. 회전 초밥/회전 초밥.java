import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		/*
		 한 위치부터 k개의 접시를 연속해서 먹으면 할인된 정액 가격으로 제공
		 요리사가 쿠폰 제공
		 * */
		int[] chobab = new int[n];
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			chobab[i] = a;
		}
		
		int[] num = new int[d + 1];
		int ans = 1;
		num[c] ++;
		for (int i = 0; i < k; i++) {
			if(num[chobab[i]] == 0) {
				ans++;
			}
			num[chobab[i]] ++;
		}
	
		int start = 0;
		int end = k - 1;

		int cnt = ans;
		while(start < n) {
			end++;
			if(num[chobab[end % n]] == 0) {
				cnt++;
			}
			num[chobab[end % n]] ++;
			
			num[chobab[start]]--;
			if(num[chobab[start]] == 0) {
				cnt--;
			}
			start++;
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
}
