import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] check = new int[26];
        int no = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(check, 0);
            char[] arr = br.readLine().toCharArray();
            char now = ' ';
            for (int j = 0; j < arr.length; j++) {
                if(now != arr[j]){
                    now = arr[j];
                    if(check[arr[j]-97] != 0) {
                        no++;
                        break;
                    }
                    check[arr[j]-97]++;
                }else{
                    check[arr[j]-97]++;
                }
            }
        }
        System.out.println(n-no);
    }
}