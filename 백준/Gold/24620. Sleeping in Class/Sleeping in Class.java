import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // 배열의 합의 약수 구하기
    public static ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) { // 제곱수 예외 처리
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 (1 ~ 10)
        for (int ss = 0; ss < t; ss++) {
            int n = Integer.parseInt(br.readLine()); // 수업 기간 (1 ~ 100000)
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int s = 0; // 배열의 합
            for (int value : arr) {
                s += value;
            }
            ArrayList<Integer> divisors = getDivisors(s); // 합의 약수 배열
            Collections.sort(divisors);

            int ans = 0;
            for (int divisor : divisors) {
                int arrSum = 0;
                boolean tf = true;

                for (int j = 0; j < n; j++) {
                    arrSum += arr[j];
                    if (arrSum > divisor) {
                        tf = false;
                        break;
                    } else if (arrSum == divisor) {
                        arrSum = 0;
                    }
                }

                if (tf) {
                    ans = n - (s / divisor);
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
