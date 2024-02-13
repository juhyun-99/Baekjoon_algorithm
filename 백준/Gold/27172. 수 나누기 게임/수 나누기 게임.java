import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int MAX = 1000000;

        boolean[] card = new boolean[MAX + 1];
        int[] score = new int[MAX + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            card[arr[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 2 * arr[i]; j < MAX + 1; j += arr[i]) {
                if (card[j]) {
                    score[arr[i]]++;
                    score[j]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(score[arr[i]]).append(' ');
        }

        System.out.println(sb);
    }
}