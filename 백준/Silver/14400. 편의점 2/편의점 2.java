import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);
        Arrays.sort(y);

        int midX = x[n/2];
        int midY = y[n/2];

        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.abs(x[i] - midX);
            ans += Math.abs(y[i] - midY);
        }
        System.out.println(ans);
    }
}
