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
		int r = 0, c = 0;
	
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if(i <= j && i * j == s.length()) {
					r = i;
					c = j;
				}
			}
		}
		
		char[][] arr = new char[r][c];
		int idx = 0;
		for (int j = 0; j < c; j++) {
			for (int j2 = 0; j2 < r; j2++) {
				arr[j2][j] = s.charAt(idx++);
			
			}
		}
		
		for (int j = 0; j < r; j++) {
			for (int j2 = 0; j2 < c; j2++) {
				System.out.print(arr[j][j2]);
			
			}
		}
	}
}