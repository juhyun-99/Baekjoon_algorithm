import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[b + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i < b + 1; i++) {
            if(!isPrime[i]) continue;
            for (int j = 2 * i; j < b + 1; j+= i) {
                isPrime[j] = false;
            }
        }

        for (int i = a; i <= b ; i++) {
            if(!isPrime[i]) continue;
            String tmp = i + "";
            boolean tf = true;
            for (int j = 0; j < tmp.length()/2; j++) {
                if(tmp.charAt(j) != tmp.charAt(tmp.length() - 1 - j)){
                    tf = false;
                    break;
                }
            }
            if(tf) sb.append(i + "\n");
        }
        sb.append(-1);
        System.out.println(sb);

    }
}
