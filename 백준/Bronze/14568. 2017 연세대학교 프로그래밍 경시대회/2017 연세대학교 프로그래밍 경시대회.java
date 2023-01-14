import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i < n; i++) { //택희
            if(i % 2 == 1) continue;
            for (int j = 1; j < n; j++) { //영훈
                for (int k = 0; k < n; k++) { //남규
                    if(i + j + k != n) continue;
                    if(k < j + 2) continue;

                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}