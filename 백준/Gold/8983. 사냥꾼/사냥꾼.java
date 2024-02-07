import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] animal = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            animal[i][0] = Integer.parseInt(st.nextToken());
            animal[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            int start = 0;
            int end = m - 1;
            while(start <= end) {
                int mid = (start + end) / 2;
                long diff = Math.abs(arr[mid] - animal[i][0]) + animal[i][1];
                if(diff <= l) {
                    cnt++;
                    break;
                }
                if(animal[i][0] < arr[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        System.out.println(cnt);
    }
}