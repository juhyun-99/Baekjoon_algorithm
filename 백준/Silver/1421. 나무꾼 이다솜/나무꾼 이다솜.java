import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] tree = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, tree[i]);
        }

        long ans = Long.MIN_VALUE;
        for (int i = 1; i <= max; i++) { //1부터 max 길이까지
            long sum = 0;
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                if (tree[j] >= i) {
                    if (tree[j] % i != 0) { //나머지가 0이 아닐 때
                        cnt = tree[j] / i;
                    }
                    else{
                        cnt = tree[j] / i - 1;
                    }
                    long tmp = (tree[j] / i) * i * w - cnt * c;

                    if (tmp > 0)
                        sum += tmp;
                }

            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}