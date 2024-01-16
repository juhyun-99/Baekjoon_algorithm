import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long diff = Long.MAX_VALUE;
        long ans1 = 0;
        long ans2 = 0;
        long multi = a * b;
        for (long i = a; i * i <= multi; i+= a) {
            long num1 = i;
            long num2 = multi / i;
            if(gcd(num2, num1) == a && (num2/a)*num1 == b){
                long tmp = num1 + num2;
                if(diff > tmp){
                    diff = tmp;
                    ans1 = num1;
                    ans2 = num2;
                }
            }
        }
        System.out.println(ans1 + " " + ans2);

    }
    public static long gcd(long a, long b){
        while(a % b != 0){
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return b;
    }
}
