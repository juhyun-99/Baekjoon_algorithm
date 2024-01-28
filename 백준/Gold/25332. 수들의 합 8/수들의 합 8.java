import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] brr = new int[n + 1];

        long cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        long[] aPrefix = new long[n + 1];
        long[] bPrefix = new long[n + 1];
        TreeMap<Long, Integer> check = new TreeMap<>();
        for (int i = 1; i < n + 1; i++) {
            aPrefix[i] = arr[i] + aPrefix[i - 1];
            bPrefix[i] = brr[i] + bPrefix[i - 1];
            long tmp = aPrefix[i] - bPrefix[i];
            if(tmp == 0) cnt++;
            if(check.containsKey(tmp)){
                cnt += check.get(tmp);
            }

            if(check.containsKey(tmp)){
                check.put(tmp, check.get(tmp) + 1);
            }else{
                check.put(tmp, 1);
            }
        }
        System.out.println(cnt);
    }
}
