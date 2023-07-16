import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int num1 = 0;
        int num2 = n - 1;
        int cnt = 0;

        while(num1 < num2){
            int tmp = arr[num1] + arr[num2];
            if(tmp == x){
                cnt++;
                num1++;
                num2--;
            }
            else if(tmp < x){
                num1++;
            }
            else{
                num2--;
            }
        }
        System.out.println(cnt);
    }
}