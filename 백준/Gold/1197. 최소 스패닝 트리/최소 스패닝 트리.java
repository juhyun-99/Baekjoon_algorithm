import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
	int from;
	int to;
	int weight;
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
	
}
public class Main {
	static int v, e;
	static Edge[] edges;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edges = new Edge[e]; 
        parents = new int[v];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to ,weight);
        }
        make();
        Arrays.sort(edges);
        long sum = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if(union(edge.from, edge.to)) {
                sum+=edge.weight;
                if(++cnt == v-1) {
                    break;
                }
            }
        }
        System.out.println(sum);
		
	}
	private static void make() {
		parents = new int[v + 1];
		for (int i = 1; i < v + 1; i++) {
			parents[i] = i;
		}
		
	}
	private static boolean union(int from, int to) {
		int aRoot = find(from);
		int bRoot = find(to);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
}
