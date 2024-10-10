import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (s1, s2) ->{
            if(s1.length() == s2.length())
                return s1.compareTo(s2);
            else{
                return s1.length() - s2.length();
            }
        }
        );
        System.out.println(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].equals(arr[i - 1])) continue;
            System.out.println(arr[i]);
        }
    }
}
