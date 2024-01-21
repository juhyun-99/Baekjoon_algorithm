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
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] prefix = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int start = 0;
        int end = 1;
        int ans = Integer.MAX_VALUE;
        //System.out.println(Arrays.toString(prefix));
        while(end <= n){
            //System.out.println(start + " " + end);
            if(prefix[end] < s) end++;
            else{
                if(prefix[end] - prefix[start] >= s){
                    ans = Math.min(ans, end - start);
                    start++;
                }else{
                    end++;
                }
            }
        }
        if(ans==Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(ans);
        }

    }
}
