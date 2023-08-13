import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int[] arr = new int[n + 2];
			List<Integer> door = new ArrayList<>();
			door.add(0);
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			arr[0] = 1; arr[n + 1] = 1;
			int ans = 0;
			for (int i = 0; i < door.size(); i++) {
				boolean tf = false;
				if(door.get(i) == n + 1) break;
				for (int j = d; j > 0 ; j--) {
					if(door.get(i) + j > n + 1) continue;
					if(arr[door.get(i) + j] == 1) {
						door.add(door.get(i) + j);
						tf = true;
						break;
					}
				}
				if(!tf) {
					door.add(door.get(i) + d);
					ans++;
				}
			}
			sb.append("#" + test + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
