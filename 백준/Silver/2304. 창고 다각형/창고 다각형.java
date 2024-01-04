import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int maxH = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
            if(maxH < h){
                maxIdx = l;
                maxH = h;
            }
        }

        int sum = 0;
        int h = 0;
        for (int i = 0; i < maxIdx; i++) {
            h = Math.max(h, arr[i]);
            sum += h;
        }

        h = 0;
        for (int i = 1000; i >= maxIdx ; i--) {
            h = Math.max(h, arr[i]);
            sum += h;
        }
        System.out.println(sum);
    }
}