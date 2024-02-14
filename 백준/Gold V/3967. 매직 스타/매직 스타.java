import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] alpha = new char[12];
    static boolean[] visit = new boolean[12];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        Arrays.fill(alpha, '0');
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                if(s.charAt(j) != '.' && s.charAt(j) != 'x'){
                    alpha[idx] = s.charAt(j);
                    visit[s.charAt(j) - 65] = true;
                    idx++;
                }
                if(s.charAt(j) == 'x') idx++;
            }
        }
//        System.out.println(Arrays.toString(alpha));

        recursive(0);
    }
    public static void recursive(int cur){
        if(cur < 12 && alpha[cur] != '0'){
            recursive(cur + 1);
            return;
        }

        if(cur == 12){
            if(check()){
//                System.out.println(Arrays.toString(alpha));
                sb.append("...." + alpha[0] + "....\n.");
                for (int i = 1; i < 5; i++) {
                    sb.append(alpha[i]+".");
                }
                sb.append("\n");
                sb.append(".." + alpha[5] + "..." + alpha[6] + "..\n.");
                for (int i = 7; i < 11; i++) {
                    sb.append(alpha[i]+".");
                }
                sb.append("\n");
                sb.append("...." + alpha[11] + "....");
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < 12; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            alpha[cur] = (char) (i + 65);
            recursive(cur + 1);
            alpha[cur] = '0';
            visit[i] = false;

        }
    }

    public static boolean check(){
/*
....0....
.1.2.3.4.
..5...6..
.7.8.9.10
....11...
*
* */
        if(alpha[0] + alpha[2] + alpha[5] + alpha[7] - 260 + 4 == 26
                && alpha[1] + alpha[2] + alpha[3] + alpha[4] - 260 + 4 == 26
                && alpha[1] + alpha[5] + alpha[8] + alpha[11] - 260 + 4 == 26
                && alpha[0] + alpha[3] + alpha[6] + alpha[10] - 260 + 4 == 26
                && alpha[7] + alpha[8] + alpha[9] + alpha[10] - 260 + 4 == 26
                && alpha[4] + alpha[6] + alpha[9] + alpha[11] - 260 + 4 == 26) return true;
        else return false;
    }

}
