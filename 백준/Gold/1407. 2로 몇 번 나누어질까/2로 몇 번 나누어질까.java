import java.util.*;
public class Main {
    static long cnt(long num){
        if (num == 1) return 1;
        if (num != 0 && num % 2 == 0) return cnt(num/2) * 2 + num/2;
        if (num !=1 && num % 2 == 1) return cnt(num - 1) + 1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(cnt(b) - cnt(a - 1));
    }
}