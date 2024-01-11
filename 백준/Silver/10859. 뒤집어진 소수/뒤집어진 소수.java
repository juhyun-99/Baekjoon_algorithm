import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long n = Long.parseLong(str);

        boolean tf = false;
        if(isPrime(n)){
            if(check(str)){
                String reverse = "";
                for (int i = str.length() - 1; i >= 0 ; i--) {
                    char tmp = str.charAt(i);
                    if(tmp == '6') reverse += '9';
                    else if(tmp == '9') reverse += '6';
                    else reverse += tmp;
                }

                if(isPrime(Long.parseLong(reverse))) tf = true;
            }
        }

        if(tf) System.out.println("yes");
        else System.out.println("no");
    }

    public static boolean check(String num){
        for (int i = 0; i < num.length(); i++) {
            char tmp = num.charAt(i);
            if(tmp == '3' || tmp == '4' || tmp == '7'){
                return false;
            }
        }
        return true;
    }
    public static boolean isPrime(long num){
        if(num == 1) return false;
        for (long i = 2; i * i <= num ; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
