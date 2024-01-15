import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(cnt(b) - cnt(a - 1));
    }

    static long cnt(long num){
        if (num == 1) return 1;
        if (num != 0 && num % 2 == 0) return cnt(num/2) * 2 + num/2;
        if (num % 2 == 1) return cnt(num - 1) + 1;
        return 0;
    }
}