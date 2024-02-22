import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] arr;
    static int n;
    static int len;
    static int diff = Integer.MAX_VALUE;
    static int cNum = -1;
    static int ans = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String tmp = br.readLine();
        n = Integer.parseInt(tmp);
        len = tmp.length();
        int m = Integer.parseInt(br.readLine());
        arr = new boolean[10];
        Arrays.fill(arr, true);
        if(m > 0){ //고장난 버튼이 있을 때
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr[Integer.parseInt(st.nextToken())] = false;
            }
        }
        if(m < 10){
            for (int i = Math.max(1, len - 1); i <= len + 1; i++) {
                recursive(0, i, 0); //남은 번호로 눌렀을 때 가장 가까운 수 구하기
            }
        }

        //0만 따로
        if(arr[0] == true){
            if(diff > Math.abs(n - 0)){
                ans = 1;
                cNum = 0;
            }
        }

        //System.out.println(cNum + " " + ans + " " + diff);
        System.out.println(Math.min(Math.abs(100 - n), Math.abs(n - cNum) + ans));

    }

    private static void recursive(int cur, int end, int num) { //가장 가까운 수 찾기
        if(cur == end){
            int tmp = Math.abs(n - num);
            if(diff > tmp){
                diff = tmp;
                cNum = num;
                ans = end;
                //System.out.println(cNum + " " + ans + " " + diff);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(!arr[i]) continue; // 고장난 버튼이면 패스
            if(cur == 0 && i == 0) continue;
            recursive(cur + 1, end, num * 10 + i);
        }
    }

}
