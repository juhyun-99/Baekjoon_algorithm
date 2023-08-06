import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int a = Integer.parseInt(stk.nextToken());
        int cnt = n / a;
        int tmp = n / a;
        
        while(tmp >= a){
            tmp /= a;
            cnt += tmp;
        }
        System.out.println(cnt);
    }

}
