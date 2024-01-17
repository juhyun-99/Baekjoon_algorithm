import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long a = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());
        long q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            long l = Integer.parseInt(st.nextToken());
            long r = Integer.parseInt(st.nextToken());
            if(cmd == 1){
                long sum = r * (2 * a + (r - 1) * d)/2;
                long sum2 = (l - 1) * (2 * a + (l - 2) * d)/2;
                sb.append(sum - sum2 + "\n");
            }
            else{
                if(l == r){
                    sb.append(a + (l-1)*d+ "\n");
                }else {
                    if(d == 0){
                        sb.append(a + "\n");
                    }else{
                        sb.append(gcd(a, d)+ "\n");
                    }
                }
            }

        }
        System.out.println(sb);
    }

    public static long gcd(long a, long b){
        if(b == 0) return a;
        while(a % b != 0){
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return b;
    }


}
