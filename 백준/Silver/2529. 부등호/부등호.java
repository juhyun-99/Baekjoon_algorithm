import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static char[] arr;
    static boolean[] visit = new boolean[10];
    static int[] sel;
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        sel = new int[k + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }


        recursive(0);
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));

    }

    private static void recursive(int cur) {
        if(cur == k + 1){
            String tmp = "";
            for (int i = 0; i < sel.length; i++) {
                tmp += sel[i];
            }
            list.add(tmp);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(visit[i]) continue;

            if(cur > 0){
                if(arr[cur - 1] == '>'){
                    if(i > sel[cur - 1]) continue;
                }
                else if(arr[cur - 1] == '<'){
                    if(i < sel[cur - 1]) continue;
                }
            }

            visit[i] = true;
            sel[cur] = i;
            recursive(cur + 1);
            visit[i] = false;
        }
    }
}
