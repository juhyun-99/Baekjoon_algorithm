import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = 0;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if(arr[i] > arr[i + 1]){
                cnt++;
                tmp = i + 1;
            }
        }

        if(cnt == 0){
            System.out.println(n);
        }else if(cnt >= 2){
            System.out.println(0);
        }else{
            int ans = 0;
            if(tmp == 1 || arr[tmp] >= arr[tmp - 2]){
                ans++;
            }
            if(tmp == n - 1 || arr[tmp + 1] >= arr[tmp - 1]){
                ans++;
            }
            System.out.println(ans);
        }
    }
}
