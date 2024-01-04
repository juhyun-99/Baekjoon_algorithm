import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] str = new int[n];
        int[] dex = new int[n];
        int[] intt = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = Integer.parseInt(st.nextToken());
            dex[i] = Integer.parseInt(st.nextToken());
            intt[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    int cnt = 0;
                    for (int m = 0; m < n; m++) {
                        if(str[i] >= str[m] && dex[j] >= dex[m] && intt[l] >= intt[m]) cnt++;
                    }
                    if(cnt >= k) ans = Math.min(ans, str[i] + dex[j] + intt[l]);
                }
            }
        }

        System.out.println(ans);

    }
}