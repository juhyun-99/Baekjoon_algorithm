import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int l, c;
    static char[] arr;
    static char[] sel;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        sel = new char[l];
        arr = new char[c];
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        recursive(0, 0, 0, 0);
        /*
        * 암호는 최소 한개의 모음과 두개의 자음임
        * 암호는 정렬된 순서임
        * */
        System.out.println(sb);

    }


    private static void recursive(int cur, int start, int ja, int mo) {
        if(cur == l){
            if(ja >= 1 && mo >= 2){
                for (int i = 0; i < l; i++) {
                    sb.append(sel[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < c; i++) {
            sel[cur] = arr[i];
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                recursive(cur + 1, i + 1, ja + 1, mo);
            }else{
                recursive(cur + 1, i + 1, ja, mo + 1);
            }
        }
    }
}
