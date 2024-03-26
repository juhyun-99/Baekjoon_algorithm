import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (true) {
            int idx = arr.indexOf(Collections.max(arr));
            if (dasom > arr.get(idx)) {
                break;
            }

            arr.set(idx, arr.get(idx) - 1);
            dasom += 1;
            cnt += 1;
        }
        System.out.println(cnt);
    }
}
