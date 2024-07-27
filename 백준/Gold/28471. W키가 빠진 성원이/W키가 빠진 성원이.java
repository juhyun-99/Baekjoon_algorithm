import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, -1, 0, 0, 1, -1, 1};
    static int[] dy = {-1, 1, -1, 1, 1, 0, -1};
    static int n, ans;
    static char[][] arr;
    static boolean[][] visit;
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 'F') {
                    q.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            
            for (int i = 0; i < 7; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n
                        && !visit[nx][ny] && arr[nx][ny] == '.') {
                    q.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    ans++;
                }
            }
        }
    }
}
