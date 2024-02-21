import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        recursive(0, 0, 0);
        System.out.println(ans);


    }

    private static void recursive(int cur, int cnt, int total) {
        if(cur == n){
            if(cnt == 0) return;
            if(total == s){
                ans++;
            }
            return;
        }

        //안 넣은거
        recursive(cur + 1, cnt, total);

        //넣은거
        recursive(cur + 1, cnt + 1, total + arr[cur]);
    }
}
