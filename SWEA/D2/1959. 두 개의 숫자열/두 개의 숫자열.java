import java.util.Scanner;
import java.io.FileInputStream;



class Solution
{
    public static int returnNum(int[] a, int[] b){
        int ans = 0;
        for (int i = 0; i <= b.length - a.length; i++) {
            int tmp = 0;
            for (int j = 0; j < a.length; j++) {
                tmp += a[j] * b[j + i];
            }
            if(ans < tmp){
                ans = tmp;
            }
        }
        return ans;
    }

    public static void main(String args[]) throws Exception
    {
        
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int ans;
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            if(n < m){
                ans = returnNum(a, b);
            }
            else{
                ans = returnNum(b, a);
            }
            
            
            
            System.out.printf("#%d %d\n", test_case, ans);
        }
    }
}