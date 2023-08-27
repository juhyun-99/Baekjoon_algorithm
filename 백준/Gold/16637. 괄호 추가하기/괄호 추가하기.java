import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	private static final int ArrayList = 0;
	static int n;
	static List<Integer> number;
	static List<Character> pmm;
	static int ans;
	static boolean[] sel;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		number = new ArrayList<>();
		pmm = new ArrayList<>();
		String s = br.readLine();

		for (int i = 0; i < n; i++) {
			if(i % 2 ==0) {
				number.add(s.charAt(i) -'0');
			}
			else {
				pmm.add(s.charAt(i));
			}
		}
		
		ans = number.get(0);
		
		for (int i = 0; i < pmm.size(); i++) {
			if(pmm.get(i) == '+') {
				ans  += number.get(i + 1);
			}else if(pmm.get(i) == '*') {
				ans *= number.get(i + 1);
			}
			else {
				ans -=number.get(i + 1);
			}
		}
		
		dfs(0, number.get(0));
		System.out.println(ans);
		
	}
	private static void dfs(int idx, int value) {
		if(idx >= pmm.size()) {
			ans = Math.max(ans, value);
			return;
		}
		
		//괄호를 안친다.
		int result =  caculation(idx, value, number.get(idx + 1));
		dfs(idx + 1, result);
		
		//내 뒤 연산자를 괄호 쳐서 더한다.
		if(idx + 1 >= pmm.size()) return;
		int result2 = caculation(idx + 1, number.get(idx + 1), number.get(idx + 2));
		int result3 = caculation(idx, value, result2);
		dfs(idx + 2, result3);

	}

	private static int caculation(int idx, int value, int backNumber) {
		switch(pmm.get(idx)) {
		case'+':
			return value + backNumber;
		case '-':
			return value - backNumber;
		case '*':
			return value * backNumber;
		}
		return 0;
	}
}