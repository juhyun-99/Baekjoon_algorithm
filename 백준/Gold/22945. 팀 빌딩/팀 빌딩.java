import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = Integer.MIN_VALUE;

        int start = 0;
        int end = n - 1;
        
        while(start < end){
            ans = Math.max(ans,(end - start - 1) 
                           * Math.min(arr[start], arr[end]));
            
            if(arr[start] < arr[end]){
                start++;
            }
            else{
                end--;
            }
        }
        System.out.println(ans);
    }
}
