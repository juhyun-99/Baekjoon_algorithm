import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        dfs(1);
        int ans = 0;
        for (int i = 2; i <= n ; i++) {
            if(visit[i]) ans++;
        }
        System.out.println(ans);
    }

    private static void dfs(int cur) {
        if(visit[cur]) return;

        visit[cur] = true;
        ArrayList<Integer> list = arr[cur];
        for (int i = 0; i < list.size(); i++) {
            if(!visit[list.get(i)]){
                dfs(list.get(i));
            }
        }
    }
}
