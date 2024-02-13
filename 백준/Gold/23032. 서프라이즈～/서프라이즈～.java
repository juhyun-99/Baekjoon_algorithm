import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0) prefix[i] = arr[i];
            else prefix[i] = prefix[i - 1] + arr[i];
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int left = i;
                int right = j;
                while(left <= right){
                    int mid = (left + right) / 2;

                    int lsum = prefix[mid] - (i == 0 ? 0 : prefix[i - 1]);
                    int rsum = prefix[j] - prefix[mid];

                    if(min > Math.abs(lsum - rsum)){
                        min = Math.abs(lsum - rsum);
                        ans = prefix[j] - (i == 0 ? 0 : prefix[i - 1]);
                    } else if(min == Math.abs(lsum - rsum)){
                        ans = Math.max(ans, prefix[j] - (i == 0 ? 0 : prefix[i - 1]));
                    }

                    if(lsum < rsum){
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
