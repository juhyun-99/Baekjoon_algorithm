import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
    static int ans;
    static int[] sel;
    static int[] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            n = Integer.parseInt(br.readLine());
            ans = 0;
            sel = new int[3];
            arr = new int[n];

            st = new StringTokenizer(br.readLine());

            TreeSet<Integer> set = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                set.add(arr[i]);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i == j) continue;
                    if(arr[i] > arr[j]) set.add(arr[i] - arr[j]);
                }
            }

            Integer[] list = set.toArray(new Integer[set.size()]);
            Arrays.sort(list);
//            System.out.println("arr : " + Arrays.toString(arr));
//            System.out.println("list : " + Arrays.toString(list));
            recursive(0, 0, list);
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int cur, int start, Integer[] list) {
        if(cur == 3){
            if(check()){
//                System.out.println(Arrays.toString(sel));
                ans++;
            }
            return;
        }

        for (int i = start; i < list.length; i++) {
            sel[cur] = list[i];
            recursive(cur + 1, i, list);
        }
    }

    public static boolean check(){
        int[] checkList = {sel[0], sel[1], sel[2],
                sel[0] + sel[1], sel[1] + sel[2], sel[0] + sel[2],
                sel[0] + sel[1] + sel[2]};

        boolean[] visit = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[j] && checkList[i] == arr[j]){
                    visit[j] = true;
                    cnt++;
                }
            }
        }
        if(cnt == n) return true;
        return false;

    }
}
