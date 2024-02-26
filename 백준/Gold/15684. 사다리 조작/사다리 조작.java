import java.util.*;
import java.io.*;

public class Main {
    static int n, m, h;
    static int ans = Integer.MAX_VALUE;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new boolean[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
        }

        for (int i = 0; i <= 3; i++) {
            recursive(0, i);
            if(ans != Integer.MAX_VALUE) break;
        }
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        System.out.println(ans);


    }

    private static void recursive(int cur, int end) {
        if(cur == end){
            if(!check()) return;
            ans = end;
            return;
        }

        for (int i = 1; i <= h ; i++) {
            for (int j = 1; j <= n; j++) {
                if(arr[i][j] || ((j - 1) >= 1 && arr[i][j - 1]) || ((j + 1) <= n && arr[i][j + 1])) continue;
                arr[i][j] = true;
                recursive(cur + 1, end);
                arr[i][j] = false;
            }
        }


    }

    private static boolean check() {
        //print();
        for (int i = 1; i < n + 1; i++) {
            int start = i;
            for (int j = 1; j < h + 1; j++) {
                if(start - 1 >= 1 && arr[j][start - 1]){
                    start--;
                }
                else if(start <= n && arr[j][start]){
                    start++;
                }
            }
            //System.out.println(i + " " + start);
            if(i != start) return false;
        }
        return true;
    }

    private static void print() {
        for (int i = 1; i < h + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
