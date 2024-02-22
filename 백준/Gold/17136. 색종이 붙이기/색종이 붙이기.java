import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    static boolean[][] visit;
    static int[] paper = new int[]{0,5,5,5,5,5};

    static ArrayList<Point> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[10][10];
        visit = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    list.add(new Point(i, j));
                }
            }
        }

        if(list.size() == 0){
            System.out.println(0);
            System.exit(0);
        }
        recursive(0, 0);
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        System.out.println(ans);
    }

    private static void recursive(int cur, int cnt) {
        if(cnt >= ans) return;

        if(cur == list.size()){
            //print();
            ans = Math.min(ans, cnt);
            return;
        }

        Point p = list.get(cur);
        int x = p.x;
        int y = p.y;
        if(visit[x][y]){
            recursive(cur + 1, cnt);
            return;
        }

        for (int i = 1; i <= 5 ; i++) {
            if(paper[i] == 0) continue;
            if(!check(x, y, i)) continue;
            put(x, y, i);
            recursive(cur + 1, cnt + 1);
            rollback(x, y, i);
        }
    }

    private static void put(int x, int y, int num) {
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                visit[i][j] = true;
            }
        }
        paper[num]--;
    }

    private static void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void rollback(int x, int y, int num) {
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                visit[i][j] = false;
            }
        }
        paper[num]++;
    }

    private static boolean check(int x, int y, int num) {
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                if(i >= 10 || j >= 10) {
                    return false;
                }
                if(visit[i][j] || arr[i][j] == 0){
                    return false;
                }
            }
        }
        return true ;
    }
}
