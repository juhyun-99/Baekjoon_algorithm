import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		int[][] arr = new int[n][5];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(stk.nextToken());
			arr[i][0] = num / 100; num %= 100;
			arr[i][1] = num / 10;
			arr[i][2] = num % 10;
			arr[i][3] = Integer.parseInt(stk.nextToken());
			arr[i][4] = Integer.parseInt(stk.nextToken());
		}
		int ans = 0;
		
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					if(i == j || j == k || i == k) {
						continue;
					}
					
					int cnt = 0;
					for (int l = 0; l < arr.length; l++) {
						int strike = 0;
						int ball = 0;
						if(arr[l][0] == i) strike++;
						if(arr[l][1] == j) strike++;
						if(arr[l][2] == k) strike++;
						
						if(arr[l][1] == i || arr[l][2] == i) ball++;
						if(arr[l][0] == j || arr[l][2] == j) ball++;
						if(arr[l][1] == k || arr[l][0] == k) ball++;
						if(strike == arr[l][3] && ball == arr[l][4]) {
							cnt++;
						}
						else {
							break;
						}
					}
					if(cnt==n) {
						ans++;
					}
				}
			}
		}
		System.out.println(ans);

	}
}
