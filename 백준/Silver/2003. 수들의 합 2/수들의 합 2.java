import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;

        int num1 = 0;
        int num2 = 0;
        long sum = arr[num1];

        while(true){
            if(sum < m){
                num2 += 1;
                if(num2 >= n) break;
                sum += arr[num2];
            }else if(sum == m){
                cnt++;
                sum -= arr[num1];
                num1++;
            }else{
                sum -= arr[num1];
                num1++;
            }
//            System.out.println(num1 + " " + num2 + " " + sum);
        }
        System.out.println(cnt);


    }
}
