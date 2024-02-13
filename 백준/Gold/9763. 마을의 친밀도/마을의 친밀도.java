import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int first = Integer.MAX_VALUE - 1;
            int second = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                int diff = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]) + Math.abs(arr[i][2] - arr[j][2]);

                if(first > diff){
                    second = first;
                    first = diff;
                }else if(second > diff){
                    second = diff;
                }
            }
//            System.out.println(second + " " + first);
            ans = Math.min(second + first, ans);
        }
        System.out.println(ans);


    }
}
