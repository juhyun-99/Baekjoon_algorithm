import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] isPrime = new boolean[4000001];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < isPrime.length; i++) {
            if(!isPrime[i]) continue;
            for (int j = i * i; j < isPrime.length ; j+=i) {
                isPrime[j] = false;
            }
        }
       // System.out.println(Arrays.toString(isPrime));
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = a; i <= b ; i++) {
            if(isPrime[i]){
                int num = i;
                while(num > 0){
                    if(num % 10 == d){
                        ans++;
                        break;
                    }
                    num /= 10;
                }
            }
        }
        System.out.println(ans);
    }
}
