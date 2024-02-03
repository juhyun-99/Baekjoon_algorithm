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

        int[] tree = new int[n];
        long end = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, tree[i]);
        }

        long start = 0;
        long ans = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            long len = 0;
            for (int i = 0; i < n; i++) {
                if(tree[i] > mid) len += tree[i] - mid;
            }
            if(len < m){
                end = mid - 1;
            }else{
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
        }
        System.out.println(ans);
    }
}
