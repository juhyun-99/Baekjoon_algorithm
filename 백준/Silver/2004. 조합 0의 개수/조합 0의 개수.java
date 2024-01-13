import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long ans = Math.min(calc(n, 5) - calc(m, 5) - calc(n-m, 5),
                calc(n, 2) - calc(m, 2) - calc(n-m, 2));
        System.out.println(ans);
    }
    public static long calc(int first, int second){
        if(first == 0) return 0;
        long cnt = 0;
        long tmp = second;
        while(first >= tmp){
//            System.out.println(tmp);
            cnt += first/tmp;
            tmp *= second;
        }
        return cnt;
    }
}
