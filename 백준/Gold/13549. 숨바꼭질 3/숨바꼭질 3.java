import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point>{
    int x;
    int time;

    public Point(int x, int time){
        this.x = x;
        this.time = time;
    }

    @Override
    public int compareTo(Point o) {
        return this.time - o.time;
    }
}

public class Main {
    static int[] plus = {-1, 1, 0};
    static int[] mul = {1, 1, 2};
    static int n, k;
    static int[] visit;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new int[100001];

        Arrays.fill(visit, Integer.MAX_VALUE);
        dijkstra(n);
        System.out.println(visit[k]);
    }

    private static void dijkstra(int n) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(n, 0));
        visit[n] = 0;

        while(!q.isEmpty()){
            Point p = q.poll();

            if (visit[p.x] < p.time) continue;

            for (int i = 0; i < 3; i++) {
                int nxt = p.x * mul[i] + plus[i];
                if(0 <= nxt && nxt < 100001){
                    if(i == 2 && visit[nxt] > p.time){
                        q.add(new Point(nxt, p.time));
                        visit[nxt] = p.time;
                    }else if(visit[nxt] > p.time + 1){
                        q.add(new Point(nxt, p.time + 1));
                        visit[nxt] = p.time + 1;
                    }
                }
            }
        }
    }

}
