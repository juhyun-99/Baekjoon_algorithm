import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        Arrays.sort(arr);
        int start = 0;
        int end = 8;

        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == total - 100){
                for (int i = 0; i < 9; i++) {
                    if(i != start && i != end){
                        System.out.println(arr[i]);
                    }
                }
                break;
            }else if(sum > total - 100){
                end--;
            }else{
                start++;
            }
        }
    }
}
