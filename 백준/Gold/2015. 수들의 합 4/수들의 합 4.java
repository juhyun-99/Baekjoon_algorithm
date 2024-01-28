import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] prefix = new int[n + 1];
        TreeMap<Integer, Integer> check = new TreeMap<>();
        st = new StringTokenizer(br.readLine());
        long cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + arr[i];
            if(prefix[i] == k) cnt++;
            if(check.containsKey(prefix[i] - k)){
                cnt += check.get(prefix[i] - k);
            }

            if(check.containsKey(prefix[i])){
                check.put(prefix[i], check.get(prefix[i]) + 1);
            }else{
                check.put(prefix[i], 1);
            }
        }
        System.out.println(cnt);

    }
}
