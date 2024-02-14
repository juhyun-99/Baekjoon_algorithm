import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString = br.readLine().trim(); // 입력받은 문자열
        char[] str = (' ' + inputString).toCharArray(); // 입력받은 문자열 앞에 공백 추가

        int[] S = new int[str.length]; // 누적합 구할 배열
        HashMap<Integer, Integer> dic = new HashMap<>(); // 누적합의 첫 인덱스를 저장할 해시맵

        int ans = -1; // 정답
        int[] sc = new int[str.length];
        int[] kc = new int[str.length];

        for (int i = 1; i < str.length; i++) {
            if (str[i] == 'S') {
                S[i] = S[i - 1] + 2;
                sc[i] = sc[i - 1] + 1;
                kc[i] = kc[i - 1];
            } else if (str[i] == 'K') {
                S[i] = S[i - 1] - 1;
                sc[i] = sc[i - 1];
                kc[i] = kc[i - 1] + 1;
            } else {
                S[i] = S[i - 1];
                sc[i] = sc[i - 1];
                kc[i] = kc[i - 1];
            }

            if (S[i] == 0) {
                if (sc[i] > 0 && kc[i] > 0) {
                    ans = Math.max(ans, i);
                }
            } else {
                if (dic.containsKey(S[i])) {
                    int tmp = dic.get(S[i]);
                    if (sc[i] - sc[tmp] > 0 && kc[i] - kc[tmp] > 0) {
                        ans = Math.max(ans, i - tmp);
                    }
                }
            }

            if (kc[i] > 0 || sc[i] > 0) {
                dic.putIfAbsent(S[i], i);
            }
        }

        System.out.println(ans);
    }
}
