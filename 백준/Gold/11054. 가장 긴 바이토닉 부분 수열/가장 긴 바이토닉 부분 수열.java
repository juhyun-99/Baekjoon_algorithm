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
        int[] arr = new int[n];
        int[] left = new int[n];
        int[] right =new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j <= i ; j++) {
                if(arr[i] > arr[j]){
                    left[i] = Math.max(left[j] + 1, left[i]);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i ; j--) {
                //System.out.println(i + " " + j);
                if(arr[i] > arr[j]){
                    right[i] = Math.max(right[j] + 1, right[i]);
                }
            }
        }

//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i] - 1);
        }
        System.out.println(ans);
    }
}


