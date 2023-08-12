import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static HashMap<Integer, List<Integer>> map = new HashMap<>();
	static int[] money;
	static boolean[] visit;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		money = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n ; i++) {
			map.put(i, new LinkedList<>());
			money[i] = Integer.parseInt(st.nextToken());
		}
		visit = new boolean[n + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			map.get(num1).add(num2);
			map.get(num2).add(num1);
		}
		
		for (int i = 1; i <= n; i++) {
			if(k < 0) {
				System.out.println("Oh no");
				System.exit(0);
			}
			if(!visit[i]) {
				visit[i] = true;
				bfs(i);
			}
		}
		System.out.println(cnt);
		
	}
	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		int mon = money[num];
		while(!q.isEmpty()) {
			int idx = q.poll();
			List<Integer> tmp= map.get(idx);
			for (int i = 0; i < tmp.size(); i++) {
				if(!visit[tmp.get(i)]) {
					q.add(tmp.get(i));
					visit[tmp.get(i)] = true;
					mon = Math.min(mon, money[tmp.get(i)]);
				}
			}
		}
		k-=mon;
		cnt+=mon;
		
	}
}
