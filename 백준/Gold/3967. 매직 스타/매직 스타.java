import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static char[] alpha = new char[12];
	static boolean[] visit = new boolean[12];
	static boolean[] already = new boolean[12];
	static List<String> ans = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int cnt = 0;
	    for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				if(s.charAt(j) != '.') {
					if(s.charAt(j) != 'x') {
						visit[s.charAt(j) - 65] = true;
						alpha[cnt] = s.charAt(j);
						already[cnt] = true;
					}
					cnt++;
				}
			}
		}

	    recursive(0);

	}
	
	private static void recursive(int idx) {
		if(idx == 12) {
			if(check()) {				
				sb.append("...."+alpha[0]+ "....\n.");
				for (int i = 1; i < 5; i++) {
					sb.append(alpha[i] + ".");
				}
				sb.append("\n.."+alpha[5] + "..." + alpha[6] + "..\n.");
				for (int i = 7; i < 11; i++) {
					sb.append(alpha[i] + ".");
				}
				sb.append("\n...."+alpha[11] + "....");
				System.out.println(sb);
				System.exit(0);
			}
			return;
		}
		
		if(already[idx]) {
			recursive(idx + 1);
			return;
		}
		
		
		for (int i = 0; i < 12; i++) {
			if(!visit[i]) {
				visit[i] = true;
				alpha[idx] = (char) (i + 65);
				recursive(idx + 1);
				visit[i] = false;
			}
		}
	}

	private static boolean check() {

		if(alpha[1]-256 + alpha[5] + alpha[8] + alpha[11] != 26)return false;
		if(alpha[4] + alpha[6] + alpha[9] + alpha[11] - 256 != 26)return false;
		if(alpha[0] + alpha[3] + alpha[6] + alpha[10] - 256 != 26)return false;
		if(alpha[7] + alpha[8] + alpha[9] + alpha[10] - 256 != 26)return false;
		if(alpha[1] + alpha[2] + alpha[3] + alpha[4] - 256 != 26)return false;
		if(alpha[0] + alpha[2] + alpha[5] + alpha[7] - 256 != 26)return false;
		return true;
	}
	
}
