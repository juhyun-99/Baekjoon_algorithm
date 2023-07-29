import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[100];
        for (int test = 0; test < 10; test++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());


            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            
            while(true){
                if(n == 0)break;
                if(arr[0] == arr[99]) break;
                n--;
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }
            sb.append("#"+ (test+1) + " " + (arr[99] - arr[0]) + "\n");
        }
        System.out.println(sb);
    }

}
