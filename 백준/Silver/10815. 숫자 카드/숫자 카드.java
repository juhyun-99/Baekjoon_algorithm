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
            int start = 0;
            int end = n - 1;
            boolean check = false;
            while(start <= end){
                int mid = (start + end) / 2;
                if(num == arr[mid]){
                    sb.append(1 + " ");
                    check = true;
                    break;
                }else if(num < arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            if(!check) sb.append(0 + " ");
        }
        System.out.println(sb);
    }
}