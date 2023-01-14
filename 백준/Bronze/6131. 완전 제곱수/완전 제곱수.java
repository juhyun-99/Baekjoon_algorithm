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
        for (int i = 1; i <= 500 ; i++) { //b
            for (int j = i; j <= 500; j++) { //a
                if(j*j == i*i + n) cnt++;
            }
        }
        System.out.println(cnt);

    }
}