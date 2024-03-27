import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x;
    int time;

    public Point(int x, int time){
        this.x = x;
        this.time = time;
    }
}

public class Main {
    static int[] plus = {-1, 1, 0};
    static int[] mul = {1, 1, 2};
    static int n, k;
    static boolean[] visit;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];

        bfs(n);
        System.out.println(ans);
    }

    private static void bfs(int n) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(n, 0));
        visit[n] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.x == k){
                ans = p.time;
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nxt = p.x * mul[i] + plus[i];
                if(0 <= nxt && nxt < 100001 && !visit[nxt]){
                    queue.add(new Point(nxt, p.time + 1));
                    visit[nxt] = true;
                }
            }
        }
    }

}
