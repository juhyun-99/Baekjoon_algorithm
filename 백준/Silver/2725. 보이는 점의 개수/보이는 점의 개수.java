import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        arr[1] = 3;

        for (int i = 2; i < 1001; i++) {
            int cnt = 0;
            for (int j = 1; j < i + 1; j++) {
                if(gcd(Math.max(i, j), Math.min(i, j)) == 1){
                    cnt++;
                }
            }
            arr[i] = arr[i - 1] + cnt * 2;
        }
        
        for (int t = 0; t < c; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n] + "\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b){
        while(a % b != 0){
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return b;
    }
}