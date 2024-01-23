import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int ans = Integer.MIN_VALUE;

        int[] alpha = new int[26];
        alpha[arr[0] - 'a']++;
        
        int left = 0;
        int right = 0;
        int count = 1;

        while (right < arr.length - 1) {
            right++;

            if (alpha[arr[right] - 'a']++ == 0) count++;

            while (count > n && left < right) {
                if (--alpha[arr[left++] - 'a'] == 0) count--;
            }

            ans = Math.max(ans, right - left + 1);

        }
        System.out.println(ans);
    }
}