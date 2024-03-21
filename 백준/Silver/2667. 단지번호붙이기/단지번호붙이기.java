import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && !visit[i][j]){
                    int cnt = dfs(i, j);
                    list.add(cnt);
                    ans++;
                }
            }
        }
        Collections.sort(list);
        sb.append(ans + "\n");

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n || arr[x][y] == 0 || visit[x][y]){
            return 0;
        }
        visit[x][y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            cnt += dfs(nx, ny);
        }
        return cnt;
    }
}
