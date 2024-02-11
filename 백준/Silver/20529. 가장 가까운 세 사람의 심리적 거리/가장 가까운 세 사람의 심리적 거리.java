import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 (1 ~ 50)
        for (int ss = 0; ss < t; ss++) {
            int n = Integer.parseInt(br.readLine()); // 학생 수

            String[] student = new String[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                student[i] = st.nextToken();
            }

            if(n >= 33){ //무조건 3명이 겹치게됨.
                System.out.println(0);
                continue;
            }

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int cnt = 0;
                        for (int l = 0; l < 4; l++) {
                            cnt += student[i].charAt(l) != student[j].charAt(l) ? 1 : 0;
                            cnt += student[i].charAt(l) != student[k].charAt(l) ? 1 : 0;
                            cnt += student[j].charAt(l) != student[k].charAt(l) ? 1 : 0;
                        }
                        ans = Math.min(ans, cnt);
                        if(ans == 0) break;
                    }
                }
            }
            System.out.println(ans);

        }
    }
}
