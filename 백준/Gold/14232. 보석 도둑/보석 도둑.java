import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<Long>();
        long n = sc.nextLong();

        for (long i = 2; i * i <= n ; i++) {
            while(n % i == 0){
                list.add(i);
                n /= i;
            }
        }
        if (n != 1) list.add(n);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i)+" ");
        }
    }
}