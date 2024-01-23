import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        int left = 0;
        int right = 0;

        int wCnt = 0;
        int bCnt = 0;
        int size = 0;
        int ans = 0;

        while(right < n){
            if(bCnt > b){
                if(arr[left] == 'W') wCnt--;
                else bCnt--;

                size--;
                left++;
            }
            else{
                if(arr[right] =='W') wCnt++;
                else bCnt++;

                right++;
                size++;
            }
            if(bCnt <= b && wCnt >= w) ans = Math.max(ans, size);
        }
        System.out.println(ans);
    }
}
