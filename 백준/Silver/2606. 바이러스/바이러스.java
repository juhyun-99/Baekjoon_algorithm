import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int computer;
	static int edge, cnt;
	static boolean visit[];
	static HashMap<Integer, List<Integer>> map =  new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		computer = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		visit = new boolean[computer + 1]; 
		cnt =  0;
		for (int i = 0; i < computer; i++) {
			map.put(i + 1, new ArrayList<>());
		}
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map.get(a).add(b);
			map.get(b).add(a);
		}
//		for (int i = 0; i < computer; i++) {
//			System.out.println(map.get(i + 1).toString());
//		}
		bfs();
		System.out.println(cnt);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			List<Integer> tmp = map.get(q.poll());
			for (int i = 0; i < tmp.size(); i++) {
				if(!visit[tmp.get(i)]) {
					visit[tmp.get(i)] = true;
					q.add(tmp.get(i));
					cnt++;
				}
			}
		}
		
	}
}
