import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
	int another;
	int dist;
	Point(int another, int dist){
		this.another = another;
		this.dist = dist;
	}
	@Override
	public String toString() {
		return "Point [another=" + another + ", dist=" + dist + "]";
	}
	
}
public class Main {
	static int n;
	static int robot1, robot2, before;
	static int ans;
	static boolean visit[], tf;
	static HashMap<Integer,List<Point>> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		robot1 = Integer.parseInt(st.nextToken());
		robot2 = Integer.parseInt(st.nextToken());
		visit = new boolean[n + 1];
		for (int i = 1; i < n + 1 ; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());			
			map.get(num1).add(new Point(num2, value));
			map.get(num2).add(new Point(num1, value));
		}
		
		bfs(robot1);
		System.out.println(ans);
	}
	
	private static void bfs(int robot) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {robot, 0, 0});
		visit[robot] = true;
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int s = p[1];
			if(x == robot2) {
				ans = p[1] - p[2];
				break;
			}
			if(map.get(x) == null) continue;
			List<Point> tmp = map.get(x);
			for (int i = 0; i < tmp.size(); i++) {
				Point pp = tmp.get(i);
				if(!visit[pp.another]) {
					q.add(new int[] {pp.another, s + pp.dist , Math.max(p[2], pp.dist)});
					visit[pp.another] = true;
				}
			
			}
		}
	
	}
}
