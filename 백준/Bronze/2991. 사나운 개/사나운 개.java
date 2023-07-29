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
		stk = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int d = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		int[] person = new int[3];
		person[0] = Integer.parseInt(stk.nextToken());
		person[1] = Integer.parseInt(stk.nextToken());
		person[2] = Integer.parseInt(stk.nextToken());
		
		int max = Math.max(Math.max(person[0], person[1]), person[2]);
		
		boolean dog1 = true; 
		boolean dog2 = true;
		int dog1_time = a;
		int dog2_time = c;
		
		int time = 0;
		int[] ans = new int[3];
		while(time <= max) {
			time++;
			
			for (int i = 0; i < person.length; i++) {
				if(person[i] == time) {
					if(dog1 && dog2) ans[i] = 2;
					else if((dog1 && !dog2) || (!dog1 && dog2)) ans[i] = 1;
				}
			}
			
			dog1_time--;
			dog2_time--;
			if(dog1_time == 0) {
				if(dog1) {					
					dog1 = false; 
					dog1_time = b;
				}else {
					dog1 = true;
					dog1_time = a;
				}
			}
			if(dog2_time == 0) {
				if(dog2) {					
					dog2 = false; 
					dog2_time = d;
				}else {
					dog2 = true;
					dog2_time = c;
				}
			}
			
			
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
	}
}
