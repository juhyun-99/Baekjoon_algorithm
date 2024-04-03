import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = l; i <= r; i++) {
            Arrays.fill(visit, false); //할 때마다 초기화 해줘야함.
            ans += g(i + "");
        }

        System.out.println(ans);
    }

    private static String calc(String s) {
        visit[Integer.parseInt(s)] = true;
        int sum = 0;
        int mul = 1;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
            mul *= s.charAt(i) - '0';
        }

        String tmp = "" + sum + mul;
        return tmp;
    }

    public static int g(String s) {
        String tmp = calc(s);
        int num = Integer.parseInt(tmp);

        //x == f(x)
        if (s.equals(tmp)) return 1;

        // x >= 100000
        if (num >= 100000) return -1;

        // 이미 방문한거면
        if (visit[num]) return 0;

        return g(tmp);
    }
}