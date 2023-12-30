import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.clear();
            boolean tf = true;
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='('){
                    stack.add(str.charAt(j));
                }
                if(str.charAt(j)==')'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }else{
                        tf = false;
                        break;
                    }
                }
            }

            if(tf){
                if(!stack.isEmpty()){
                    sb.append("NO\n");
                }else{
                    sb.append("YES\n");
                }
            }else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}