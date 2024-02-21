import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n;
    static int[][] arr;
    static int[] target, current;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<String> ansList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        target = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[n][5];
        current = new int[5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            Collections.sort(ansList);
            System.out.println(ans);
            System.out.println(ansList.get(0));
        }
    }

    private static void recursive(int cur, int cnt) {
        if(cur == n){
            if(cnt == 0) return;
            for (int i = 0; i < 4; i++) {
                if(current[i] < target[i]) return;
            }
            if(current[4] <= ans){
                if(current[4] < ans){
                    ansList.clear();
                }
                ans = current[4];
                String tmp = "";
                for (int i = 0; i < list.size(); i++) {
                    tmp += list.get(i) + " ";
                }
                ansList.add(tmp);
            }
            return;
        }

        //넣는다
        for (int i = 0; i < 5; i++) {
            current[i] += arr[cur][i];
        }
        list.add(cur + 1);
        recursive(cur + 1, cnt + 1);

        list.remove(list.size() - 1);

        //안 넣는다
        for (int i = 0; i < 5; i++) {
            current[i] -= arr[cur][i];
        }

        recursive(cur + 1, cnt);
    }
}
