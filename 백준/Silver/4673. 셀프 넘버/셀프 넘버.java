import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] check = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            self(i);
        }

        for (int i = 1; i < 10001; i++) {
            if(!check[i]){
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }

    private static void self(int n) {
        int tmp = n;
        while(n != 0){
            tmp += n % 10;
            n /= 10;
        }
        if(tmp < 10001){
            check[tmp] = true;
        }
    }

}
