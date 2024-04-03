import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point>{
    int next;

    int time;

    public Point(int next, int time){
        this.next = next;
        this.time = time;
    }

    @Override
    public int compareTo(Point o) {
        return this.time - o.time;
    }
}
public class Main {
    static int n, m, x, ans = Integer.MIN_VALUE;
    static char[][] arr;
    static ArrayList<ArrayList<Point>> list1, list2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        arr = new char[n][m];

        for (int i = 0; i <= n; i++) {
            list1.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list1.get(a).add(new Point(b, t));
            list2.get(b).add(new Point(a, t));
        }

        int arr1[] = dijkstra(list1);
        int arr2[] = dijkstra(list2);
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, arr1[i] + arr2[i]);
        }
        System.out.println(ans);
    }

    private static int[] dijkstra(List<ArrayList<Point>> list) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(x, 0));
        int[] dist = new int[n + 1];
        boolean visit[] = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[x] = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            int tmp = p.next;
            if(visit[tmp]) continue;

            visit[tmp] = true;
            ArrayList<Point> li = list.get(tmp);
            for (int i = 0; i < li.size(); i++) {
                if(dist[li.get(i).next] > dist[tmp] + li.get(i).time && !visit[li.get(i).next]){
                    dist[li.get(i).next] = dist[tmp] + li.get(i).time;
                    q.add(new Point(li.get(i).next, dist[li.get(i).next]));
                }
            }
        }
        return dist;
    }
}
