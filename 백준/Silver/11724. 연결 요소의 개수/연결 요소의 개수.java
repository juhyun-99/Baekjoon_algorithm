import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static boolean[] visit;
	static int cnt = 0;
	static HashMap<Integer, List<Integer>> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			map.get(num1).add(num2);
			map.get(num2).add(num1);
		}

		for (int i = 1; i <= n ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				bfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			List<Integer> tmp = map.get(num);
			for (int j = 0; j < tmp.size(); j++) {
				if(!visit[tmp.get(j)]) {
					visit[tmp.get(j)] = true;
					q.add(tmp.get(j));
				}
			}
		}
		
	}
}
