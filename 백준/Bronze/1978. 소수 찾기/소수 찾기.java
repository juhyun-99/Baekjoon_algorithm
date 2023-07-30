import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        boolean[] sosu = new boolean[1001];
        for (int i = 0; i < sosu.length; i++) {
            sosu[i] = true;
        }
        sosu[1] = false;

        for (int i = 2; i * i <= 1000 ; i++) {
            if(!sosu[i]) continue;

            for (int j = i*i; j < 1001; j+= i) {
                sosu[j] = false;
            }
        }
        
        int n =Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(stk.nextToken());
            if(sosu[tmp]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
