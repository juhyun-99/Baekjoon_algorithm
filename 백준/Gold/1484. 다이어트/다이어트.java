import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int g = Integer.parseInt(br.readLine());


        int cnt = 0;
        long start = 1;
        long end = 2;

        while(end < 50001){
            long minus = end*end - start * start;

            if(minus == g){
                cnt++;
                sb.append(end + "\n");
                end++;
            }
            else if(minus > g){
                start++;
            }
            else{
                end++;
            }
        }
        if(cnt == 0){
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }
    }
}
