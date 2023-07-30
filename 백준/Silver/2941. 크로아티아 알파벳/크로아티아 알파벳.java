import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String s = br.readLine();
		int ans = 0;
		for (int i = 0; i < s.length() ; i++) {
			if(s.charAt(i) == '-' || s.charAt(i) == '=') {
				continue;
			}
			else {
				ans++;
				if(s.charAt(i) == 'd') {
					if(i + 1 < s.length() && i + 2 < s.length() && s.charAt(i + 1) == 'z' && s.charAt(i + 2)== '=') {
						i+=2;
					}
				}else if(s.charAt(i) == 'l') {
					if(i + 1 < s.length() && s.charAt(i + 1) == 'j') {
						i++;
					}
				}else if(s.charAt(i) == 'n') {
					if(i + 1 < s.length() && s.charAt(i + 1) == 'j') {
						i++;
					}
				}
			}
		}
		System.out.println(ans);
	}
}