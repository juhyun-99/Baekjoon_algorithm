import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.clear();
            st = new StringTokenizer(br.readLine());
            int ans = 0;
            while(st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < arr.size() - 1; j++) {
                for (int k = j + 1; k < arr.size(); k++) {

                    ans = Math.max(ans, gcd(Math.max(arr.get(j), arr.get(k)),Math.min(arr.get(j), arr.get(k))));
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);

    }

    public static int gcd(int a, int b){
        while(a % b != 0){
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return b;
    }
}
