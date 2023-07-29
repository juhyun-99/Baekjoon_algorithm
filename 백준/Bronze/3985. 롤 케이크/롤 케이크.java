import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] cake = new int[l + 1];

		int max_person = 0;
		int max_cake = 0;
		
		for (int i = 1; i < n + 1; i++) {
			stk = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(stk.nextToken());
			int num2 = Integer.parseInt(stk.nextToken());
			int tmp = num2 - num1 + 1;
			if(max_cake < tmp) {
				max_cake = tmp;
				max_person = i;
			}
			
			for (int j = num1; j <= num2; j++) {	
				if(cake[j] == 0)
					cake[j] = i;
			}
		}
		int ans_person = 0;
		int ans_cake = 0;
		
		for (int i = 1; i < n + 1; i++) {
			int tmp = 0;
			for (int j = 0; j < cake.length; j++) {
				if(cake[j] == i) {
					tmp++;
				}
			}
			if(ans_cake < tmp) {
				ans_cake = tmp;
				ans_person = i;
			}
		}
		System.out.println(max_person);
		System.out.println(ans_person);

	}
}

