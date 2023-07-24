import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1_000_000];
        boolean[] tf = new boolean[10];


        int idx = 0;
        int num = 1;

        while(idx < 1_000_000){
            int tmp = num;
            boolean able = true;

            while(tmp != 0){
                if(tf[tmp%10]){
                    able = false;
                    break;
                }
                else{
                    tf[tmp%10] = true;
                    tmp /= 10;
                }
            }
            if(able){
                arr[idx++] = num;
            }
            num++;

            for (int i = 0; i < tf.length; i++) {
                tf[i] = false;
            }
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            sb.append(arr[n - 1] + "\n");
        }

        System.out.println(sb);
//        System.out.println(Arrays.toString(arr));
    }
}
