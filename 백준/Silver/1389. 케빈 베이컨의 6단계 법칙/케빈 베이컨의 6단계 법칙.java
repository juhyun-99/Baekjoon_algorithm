import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
    static int n, m;
    static ArrayList[] list;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] =  new ArrayList();
        }
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        System.out.println(ans);
    }

    public static void bfs(int x){
        Queue<Point> q = new ArrayDeque<>();
        visit = new boolean[n + 1];
        q.add(new Point(x, 0));
        visit[x] = true;
        int ret = 0;
        while(!q.isEmpty()){
            Point p = q.poll();
            ArrayList<Integer> tmp = list[p.x];
            for (int i = 0; i < tmp.size(); i++) {
                if(!visit[tmp.get(i)]){
                    visit[tmp.get(i)] = true;
                    q.add(new Point(tmp.get(i), p.time + 1));
                    ret += p.time + 1;
                }
            }
        }
        if(min > ret){
            min = ret;
            ans = x;
        }
    }

}