import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime = new boolean[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) continue;
            for (int j = 2 * i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long sum = a + b;
            if(sum < 4) sb.append("NO\n");
            else if(sum%2==0) sb.append("YES\n");
            else {
                if(check(sum-2)){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);

    }
    public static boolean check(long num){
        if(num < 2000001) return isPrime[(int) num];
        for (int i = 2; i  < 2000001; i++) {
            if(isPrime[i] && num % i == 0) return false;
        }
        return true;
    }
}
