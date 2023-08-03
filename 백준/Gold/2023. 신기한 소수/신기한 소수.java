import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		recursive(0, 0);
		System.out.println(sb);
		
	}
	private static void recursive(int cnt, int num) {
		
		if(cnt == n) {
			num/=10;
			
			sb.append(num+ "\n");
			return;
		}
		
		for (int i = 1; i <= 9 ; i++) {
			if(cnt ==  0 && i == 1) continue;
			int tmp = num + i;
			boolean tf = true;
			
			for (int j = 2; j * j <= tmp; j++) {
				if(tmp % j == 0) {
					tf = false;
					break;
				}
			}
			if(tf) recursive(cnt + 1, (num + i) * 10);
		}
		
	}
}
