import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            sum += arr[i];
            if(diff >= Math.abs(100 - sum)){
                ans = sum;
                diff = Math.abs(100 - sum);
            }
        }
        System.out.println(ans);
    }
}