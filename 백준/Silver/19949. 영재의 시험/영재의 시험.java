import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, visit, answer;
    static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10];
        visit = new int[6];
        answer = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        recursive(0);
        System.out.println(ans);
    }

    private static void recursive(int cur) {
        if(cur == 10){
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if(answer[i] == arr[i]){
                    cnt++;
                }
            }
            if(cnt >= 5) ans++;
            return;
        }

        for (int i = 1; i < 6; i++) {
            if(cur >= 2){
                if(answer[cur - 2] == answer[cur - 1] && answer[cur - 1] == i) continue;
            }
            answer[cur] = i;
            recursive(cur + 1);
        }
    }


}
