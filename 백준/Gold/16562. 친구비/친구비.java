import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    static int n, m, k;
    static ArrayList[] list;
    static int[] money;
    static boolean[] visit;
    static int cnt = 0;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        money = new int[n + 1];
        list = new ArrayList[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            list[i] =  new ArrayList();
            money[i] = Integer.parseInt(st.nextToken());
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
            if (k < 0) {
                System.out.println("Oh no");
                System.exit(0);
            }
            if (!visit[i]) {
                min = money[i];
                visit[i] = true;
                dfs(i);
                k -= min;
                cnt += min;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int cur) {
        ArrayList<Integer> tmp = list[cur];

        for (int i = 0; i < tmp.size(); i++) {
            if (!visit[tmp.get(i)]) {
                visit[tmp.get(i)] = true;
                min = Math.min(min, money[tmp.get(i)]);
                dfs(tmp.get(i));
            }
        }
    }
}