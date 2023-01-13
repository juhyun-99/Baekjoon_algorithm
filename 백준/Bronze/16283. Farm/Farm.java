import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a =sc.nextInt(),b =sc.nextInt(),n = sc.nextInt(),w = sc.nextInt();
        int cnt = 0;
        int num1 = 0 , num2 = 0;
        for (int i = 1; i < n; i++) {
            if((i*a + (n - i) * b) == w ) {
                cnt++;
                num1 = i;
                num2 = n - i;
            }
        }
        if(cnt != 1) System.out.println(-1);
        else System.out.printf("%d %d",num1,num2);

    }
}
