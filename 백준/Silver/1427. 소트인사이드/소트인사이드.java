import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String result = new StringBuilder(new String(arr)).reverse().toString();
        System.out.println(result);
    }
}
