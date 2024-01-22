import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] check = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            check[i] = arr[i] % 2 == 0;
        }
        int ans = 0;
        int left = 0;
        int right = 0;
        int d = 0;
        while(right < n){
            if(d < k){
                if(!check[right++]) d++;
                ans = Math.max(ans, right - left - d);
            }else if(check[right]){
                right++;
                ans = Math.max(ans, right - left - d);
            }else{
                if(!check[left++]) d--;
            }
        }
        System.out.println(ans);

    }
}
