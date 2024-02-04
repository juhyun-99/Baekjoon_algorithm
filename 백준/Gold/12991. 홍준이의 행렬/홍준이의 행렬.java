import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] a;
    static long[] b;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        a = new long[n];
        b = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(b);

        long start = a[0] * b[0];
        long end = a[n - 1] * b[n - 1];

        while(start <= end){
            long mid = (start + end) / 2;
            long cnt = 0; //mid 보다 작거나 같은 것의 갯수
            for (int i = 0; i < n; i++) { // 한 행에 최대 n개,
                int num = checkSmall(i, mid);
//                System.out.println(mid + " " + num);
                cnt += num;
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

    public static int checkSmall(int idx, long limit){
        int start = 0;
        int end = n - 1;
        while(start <= end){
            int mid = (start + end) / 2;

            if(a[idx] * b[mid] <= limit){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}