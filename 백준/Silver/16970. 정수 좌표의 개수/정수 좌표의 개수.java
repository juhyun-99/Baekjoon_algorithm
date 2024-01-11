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
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int l = 0; l <= n; l++) {
                    for (int o = 0; o <= m; o++) {
                        if( i == l && j == o ) continue;
                        int x = Math.abs(i - l);
                        int y = Math.abs(j - o);
                        if(gcd(Math.max(x, y), Math.min(x, y)) + 1 == k){
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans/2);
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        while(a % b != 0){
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return b;
    }

}
