import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        for (long i = 2; i * i <= n; i++) {
			while(n % i == 0) {
				sb.append(i + " ");
				cnt++;
				n /= i;
			}
		}
        if(n != 1) {
        	sb.append(n);
        	cnt++;
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}

