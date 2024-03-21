import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int balance = 1000 - n;
        int[] coin = {500, 100, 50, 10, 5, 1};
        int cnt = 0;

        for (int i = 0; i < 6; i++) {
            cnt += balance / coin[i];
            balance %= coin[i];
        }
        System.out.println(cnt);

    }
}
