import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

        int start = 0;
        int end = n - 1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int tmp = Integer.MAX_VALUE;

        while(start < end){
//            System.out.println(start + " " + end);
            int sum = arr[start] + arr[end];
            if(tmp > Math.abs(sum)){
                min = arr[start];
                max = arr[end];
                tmp = Math.abs(sum);
            }
            if(sum > 0){
                end--;
            }
            else{
                start++;
            }
        }

        System.out.println(min + " " + max);

    }
}
