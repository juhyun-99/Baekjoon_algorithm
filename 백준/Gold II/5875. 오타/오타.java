import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push('(');
                left++;
                sum++;
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                sum--;
                right++;
            }
            if(sum <= 1) left = 0;

            //오른쪽이 더 많은 경우
            if(sum == -1) {
                ans = right;
                break;
            }
//            System.out.println(left + " " + right + " " + sum);
        }

        //왼쪽이 더 있을 때
        if(sum > 0){
            ans = left;
        }
        System.out.println(ans);
    }
}
