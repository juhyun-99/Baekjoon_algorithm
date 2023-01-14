import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int [9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int idx1 = 0,idx2 = 0;
        loop:
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(sum - (arr[i] + arr[j]) == 100){
                    idx1 = i;
                    idx2 = j;
                    break loop;
                }
            }
        }

        int [] ans = new int[7];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i != idx1 && i != idx2){
                ans[j] = arr[i];
                j ++;
            }
        }

        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }


    }
}