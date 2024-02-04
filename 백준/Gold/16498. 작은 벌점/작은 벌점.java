import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int[] b;
    static int[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[Integer.parseInt(st.nextToken())];
        b = new int[Integer.parseInt(st.nextToken())];
        c = new int[Integer.parseInt(st.nextToken())];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c.length; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int num2 = binary(a[i], b);
            int num3 = binary(a[i], c);
            ans = Math.min(ans, Math.abs(Math.max(a[i], Math.max(num2, num3)) - Math.min(a[i], Math.min(num2, num3))));
        }

        for (int i = 0; i < b.length; i++) {
            int num2 = binary(b[i], a);
            int num3 = binary(b[i], c);
            ans = Math.min(ans, Math.abs(Math.max(b[i], Math.max(num2, num3)) - Math.min(b[i], Math.min(num2, num3))));
        }

        for (int i = 0; i < c.length; i++) {
            int num2 = binary(c[i], a);
            int num3 = binary(c[i], b);
            ans = Math.min(ans, Math.abs(Math.max(c[i], Math.max(num2, num3)) - Math.min(c[i], Math.min(num2, num3))));
        }
        System.out.println(ans);

    }
    public static int binary(int num, int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int tmp = 0;
        while(start <= end){
            int mid = (start + end) / 2;

            if(Math.abs(num - arr[mid]) < min){
                min = Math.abs(num - arr[mid]);
                tmp = arr[mid];
            }
            if(arr[mid] == num){
                tmp = num;
                break;
            }
            else if(arr[mid] > num){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return tmp;
    }
}
