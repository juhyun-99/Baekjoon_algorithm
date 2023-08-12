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
	static HashMap<Integer, List<Integer>> map = new HashMap<>();
	static int[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n ; i++) {
			map.put(i, new ArrayList<>());
		}
		visit = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			map.get(n1).add(n2);
			map.get(n2).add(n1);
		}
//		for (int i = 1; i <= map.size(); i++) {
//			System.out.println(map.get(i).toString());
//		}
		System.out.println(bfs(num1, num2));
		
		
	}
	private static int bfs(int num1, int num2) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(num1);

		loop:
		while(!Q.isEmpty()) {
			int tmp = Q.poll();
			List<Integer> get = map.get(tmp);
	
			for (int i = 0; i < get.size(); i++) {
				if(visit[get.get(i)] == 0) {
					visit[get.get(i)] = visit[tmp] + 1;
					Q.add(get.get(i));
				}
			}	
		}
		
		if(visit[num2] == 0) return -1;
		else return visit[num2];
	}
}
