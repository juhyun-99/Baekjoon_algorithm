import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static class Vertex implements Comparable<Vertex> {
		int v, w;

		public Vertex(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.w, o.w);
		}
	}

	private static final int INF = Integer.MAX_VALUE;
	static int V, E, K, ans;
	static List<Vertex>[] list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		dist = new int[V + 1];
		for (int i = 0; i < V; i++) {
			list[i] = new ArrayList<>();
		}

		Arrays.fill(dist, INF);
		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Vertex(e, w));
		}

		dijkstra(K);

		for (int i = 1; i < V + 1; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE? "INF\n" : dist[i] + "\n");
		}
		
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Vertex> Q = new PriorityQueue<>();

		boolean[] v = new boolean[V + 1];

		Q.add(new Vertex(start, 0));

		dist[start] = 0;

		while (!Q.isEmpty()) {
			Vertex p = Q.poll();
			int minIdx = p.v;
			if (v[minIdx] == true)
				continue;

			v[minIdx] = true;

			for (Vertex next : list[minIdx]) {
				if (dist[next.v] > dist[minIdx] + next.w) {
					dist[next.v] = dist[minIdx] + next.w;
					Q.add(new Vertex(next.v, dist[next.v]));
				}
			}
		}
	}
}
