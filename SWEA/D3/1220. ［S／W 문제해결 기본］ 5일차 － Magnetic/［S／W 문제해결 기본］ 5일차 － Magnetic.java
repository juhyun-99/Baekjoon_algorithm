import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[][] arr = new int[100][100];
		for (int test = 1; test <= 10; test++) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			Stack<Integer> stack = new Stack<>();
			for (int j = 0; j < 100; j++) {
				stack.clear();
				for (int i = 0; i < 100; i++) {
					if(arr[i][j] == 1) {
						stack.push(arr[i][j]);
					}
					else if(arr[i][j] == 2) {
						if(!stack.isEmpty()) {
							if(stack.peek() == 1) {
								ans += stack.peek();
								stack.push(2);
							}
						}
					}
				}
			}
			sb.append("#" + test + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
