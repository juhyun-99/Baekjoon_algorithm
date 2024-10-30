import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point>{
    int to;
    int dist;
    public Point(int to, int dist){
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Point o) {
        return this.dist - o.dist;
    }

}
public class Main {
    static ArrayList<Point>[] list;
    static int v, e, k;
    static int[] distArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[v + 1];
        distArr = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, dist));
        }

        Arrays.fill(distArr, Integer.MAX_VALUE);
        dijk(k);
        for (int i = 1; i < v + 1; i++) {
            if(distArr[i] == Integer.MAX_VALUE){
                sb.append("INF\n");
                continue;
            }
            sb.append(distArr[i] + "\n");
        }
        System.out.println(sb);


    }

    private static void dijk(int k) {
        distArr[k] = 0;
        boolean[] visit = new boolean[v + 1];
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(k, 0));

        while(!q.isEmpty()){
            Point p = q.poll();
            visit[p.to] = true;
            int now = p.to;

            for(Point next : list[now]){
                if(distArr[next.to] > distArr[now] + next.dist){
                    distArr[next.to] = distArr[now] + next.dist;
                    q.add(new Point(next.to, distArr[next.to]));
                }
            }
        }
    }
}
