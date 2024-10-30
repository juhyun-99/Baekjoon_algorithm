import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
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
    static ArrayList<Point>[] list, listReverse;
    static int n, m, x;
    static int[] dist, distReverse;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken()); //n명의 학생
        m = Integer.parseInt(st.nextToken()); //m개의 마을
        x = Integer.parseInt(st.nextToken()); //x번 마을에서 파티
        list = new ArrayList[m + 1];
        listReverse = new ArrayList[m + 1];

        dist = new int[n + 1];
        distReverse = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(distReverse, Integer.MAX_VALUE);
        dist[x] = 0;
        distReverse[x] = 0;

        for (int i = 1; i < m + 1; i++) {
            list[i] = new ArrayList<>();
            listReverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, dist));
            listReverse[b].add(new Point(a, dist));
        }

        dijk(x, list, dist);
        dijk(x, listReverse, distReverse);
        int answer = Integer.MIN_VALUE;
//        System.out.println(Arrays.toString(dist));
//        System.out.println(Arrays.toString(distReverse));
        for (int i = 1; i < n + 1; i++) {
            answer = Math.max(answer, dist[i] + distReverse[i]);
        }
        System.out.println(answer);
    }

    private static void dijk(int x, ArrayList<Point>[] list, int[] dist) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(x, 0));

        while(!q.isEmpty()){
            Point p = q.poll();
            int now = p.to;

            for(Point next : list[now]){
                if(dist[next.to] > dist[now] + next.dist){
                    dist[next.to] = dist[now] + next.dist;
                    q.add(new Point(next.to, dist[next.to]));
                }
            }
        }
    }
}
