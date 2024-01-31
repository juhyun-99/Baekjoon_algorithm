import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] s = new int[h + 1];
        int[] s2 = new int[h + 1];

        for (int j = 0; j < n; j++) {
            int num = Integer.parseInt(br.readLine());

            if (j % 2 == 0) {
                s[1]++;
                s[num + 1]--;
            } else {
                s2[h]++;
                s2[h - num]--;
            }
        }

        int[] ans1 = new int[h + 1];
        int[] ans2 = new int[h + 1];
        ans2[h] = s2[h];

        for (int i = 1; i <= h; i++) {
            ans1[i] = s[i] + ans1[i - 1];
        }

        for (int i = h - 1; i > 0; i--) {
            ans2[i] = s2[i] + ans2[i + 1];
        }

        for (int i = 1; i <= h; i++) {
            ans1[i] += ans2[i];
        }

        int min = ans1[1];
        int cnt = 1;

        for (int i = 2; i <= h; i++) {
            if (ans1[i] < min) {
                min = ans1[i];
                cnt = 1;
            } else if (ans1[i] == min) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }
}
