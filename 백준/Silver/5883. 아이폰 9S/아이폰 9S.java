import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] check = new boolean[1000001];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if(!check[arr[i]]) {
                check[arr[i]] = true;
                int cnt = 1;
                int num = -1;

                for (int j = 0; j < n; j++) {
                    if(arr[i] == arr[j]) continue;

                    if(num != arr[j]){
                        cnt = 1;
                    }

                    else if(num == arr[j]){
                        cnt++;
                        ans = Math.max(ans, cnt);
                    }
                    num = arr[j];
                }
            }
        }
        System.out.println(ans);
        //수가 리스트를 관리한다 - set을 관리하는거처럼
        //set or 정렬
        //0~1000000보면서 있냐 없냐를 보는 것
        //1000부터 끝까지 보면서

    }
}