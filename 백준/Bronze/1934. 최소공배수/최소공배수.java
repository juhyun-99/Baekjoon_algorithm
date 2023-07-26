import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int a, int b){
        while( a % b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int gcd = gcd(a,b);

            sb.append(a/gcd*b + "\n");
        }
        System.out.println(sb);
    }
}
