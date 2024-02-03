import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean tf = false;
            int start = 0;
            int end = n - 1;
            int right = Integer.MAX_VALUE;
            while(start <= end){
                int mid = (start + end) / 2;
                if(arr[mid] == num){
                    right = mid;
                    start = mid + 1;
                    tf = true;
                }else if(arr[mid] > num){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            start = 0;
            end = n - 1;
            int left = 0;
            while(start <= end){
                int mid = (start + end) / 2;
                if(arr[mid] == num){
                    left = mid;
                    end = mid - 1;
                    tf = true;
                }else if(arr[mid] > num){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }

            if(tf){
                sb.append((right - left + 1) + " ");
            }else{
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

}