import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] arr = new String[c];
        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                if(i == 0) arr[j] = String.valueOf(tmp.charAt(j));
                else arr[j] += tmp.charAt(j);
            }
        }

        //System.out.println(Arrays.toString(arr));
        if(r == 2){
            System.out.println(0);
            return;
        }
        for (int i = 0; i < r - 1; i++) {
            TreeSet<String> set = new TreeSet<>();

            for (int j = 0; j < c; j++) {
                String tmp = arr[j].substring(i);
                //System.out.println(tmp);
                if(set.contains(tmp)){
                    System.out.println(i - 1);
                    return;
                }else{
                    set.add(tmp);
                }
            }
        }
        System.out.println(r - 1);



    }
}
