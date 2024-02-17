import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] col, rightDown, rightUp;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        col = new boolean[n];
        rightDown = new boolean[2 * n - 1];
        rightUp = new boolean[2 * n - 1];
        recursive(0);
        System.out.println(cnt);

    }

    private static void recursive(int cur) {
        if(cur == n){
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(col[i]) continue;
            if(rightDown[cur - i + (n - 1)]) continue;
            if(rightUp[cur + i]) continue;

            col[i] = true;
            rightDown[cur - i + (n - 1)] = true;
            rightUp[cur + i] = true;

            recursive(cur + 1);

            col[i] = false;
            rightDown[cur - i + (n - 1)] = false;
            rightUp[cur + i] = false;
        }
    }


}
