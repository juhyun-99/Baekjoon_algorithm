import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int n;
	static boolean[] visit;
	static List<Integer> ans = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n + 1];
		visit = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= n; i++) {
			visit[i] = true;
			dfs(i,i);
			visit[i] = false;
		}
		sb.append(ans.size()+"\n");
		
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i) + "\n");
		}
		System.out.println(sb);
		
	}
	private static void dfs(int num1, int target) {
		if(arr[num1] == target) {
			ans.add(target);
		}
		
		if(!visit[arr[num1]]) {
			visit[arr[num1]] = true;
			dfs(arr[num1], target);
			visit[arr[num1]] = false;
		}
	}
}
