import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int cnt = 0; //바뀌는 부분 수
        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if(tmp != str.charAt(i)){
                cnt++;
                tmp = str.charAt(i);
            }
        }
        if(cnt%2 == 1){
            cnt++;
        }
        cnt/=2;
        System.out.println(cnt);
    }
}