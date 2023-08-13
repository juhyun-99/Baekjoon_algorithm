import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= 10; test++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int [n + 4];
			st = new StringTokenizer(br.readLine());
			for (int i = 2; i < n + 2 ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			for (int i = 2; i < n + 2; i++) {
				int maxLeft = Math.max(arr[i-2], arr[i-1]);
				int maxRight = Math.max(arr[i+2], arr[i+1]);
				int max = Math.max(maxLeft, maxRight);
				if(arr[i] > max) ans+= arr[i] - max;
			}
			sb.append("#" + test + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
