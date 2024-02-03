import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long n = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;
        long ans = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            long cnt = 0; //mid 보다 작은 것의 갯수
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(n, mid / i);
            }

            if(cnt >= k){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }
        System.out.println(start);

    }
}
