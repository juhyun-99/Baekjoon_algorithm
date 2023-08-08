import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int arr[][], ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		ans = Integer.MIN_VALUE;
		recursive(0, 0);
		System.out.println(ans);
	}
	
	private static void recursive(int day, int price) {
		if(day == n) {
			ans = Math.max(ans, price);
			return;
		}
		
		if(day > n) {
			return;
		}
		
		recursive(day + arr[day][0], price + arr[day][1]);
		recursive(day + 1, price);
	}
}
