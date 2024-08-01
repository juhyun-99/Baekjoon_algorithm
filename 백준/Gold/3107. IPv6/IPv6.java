import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp[] = br.readLine().split(":");
        StringBuilder sb = new StringBuilder();

        int count = 8 - tmp.length;
        boolean tf = true;

        for (int i = 0; i < tmp.length; i++) {
            String s = tmp[i];
            if(s.length() == 4){
                sb.append(s + ":");
            }
            else if(s.length() > 0){
                for (int j = 0; j < 4 - s.length(); j++) {
                    sb.append("0");
                }
                sb.append(s +":");
            }
            else{
                if(tf){
                    for (int j = 0; j < count + 1; j++) {
                        sb.append("0000" + ":");
                    }
                    tf = false;
                    count = 0;
                }else{
                    sb.append("0000" + ":");
                }
            }
//            System.out.println(sb);
        }
        while(count > 0){
            sb.append("0000" + ":");
            count--;
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }
}
