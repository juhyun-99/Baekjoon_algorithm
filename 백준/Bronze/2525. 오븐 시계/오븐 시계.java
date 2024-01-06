import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());

        int hour = a + (b + c) / 60;
        int minute = (b + c) % 60;
        if(hour >= 24) hour -= 24;
        System.out.println(hour + " " + minute);
    }
}