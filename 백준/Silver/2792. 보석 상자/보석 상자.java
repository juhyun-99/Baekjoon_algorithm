import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] color = new int[m];
        long end = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            color[i] = Integer.parseInt(br.readLine());
            end = Math.max(color[i], end);
        }

        long start = 1;
        long ans = Integer.MAX_VALUE;

        while(start <= end){
            long mid = (start + end) / 2;
            int student = 0;
            for (int i = 0; i < m; i++) {
                student += color[i] / mid;
                if(color[i] % mid > 0) student++;
            }
//            System.out.println(mid + " " + student);
            if(student <= n){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
