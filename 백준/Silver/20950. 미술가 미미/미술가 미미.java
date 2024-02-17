import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int r, g, b;

    static int ans = Integer.MAX_VALUE;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());


        /*
        물감을 섞어 곰두리 색 물감을 만듦
        새로운 r값은 모든 물감의 r값을 더한 후 이를 물감의 개수로 나눔, 소수점 버림 g b도 동일

        곰두리색에 가장 가까움 색 = 문두리 색
        곰두리색과 문두리색의 차이를 구하라
        물감 단독은 안됨 2~7개 까지
        */
        int end = n > 7 ? 7 : n;
        //System.out.println(end);
        for (int i = 2; i <= end; i++) {
            recursive(0, 0, i, 0, 0, 0);
        }

        System.out.println(ans);
    }

    private static void recursive(int cur, int start, int end, int red, int green, int blue) {
        if(cur == end){
            int tmp = Math.abs(red / end - r) + Math.abs(green / end - g) + Math.abs(blue / end - b);
            ans = Math.min(ans, tmp);
            return;
        }

        for (int i = start; i < n; i++) {
            recursive(cur + 1, i + 1, end, red + arr[i][0], green + arr[i][1], blue + arr[i][2]);
        }
    }


}
