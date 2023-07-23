import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 남는 사탕 없어야함.
		 * 남규 > 영훈 + 2
		 * 0개 받는 사람 없음
		 * 택희 % 2 != 1
		 * */
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i = 1; i < n - 1; i ++) { //택희
			if(i % 2 == 1) {
				continue;
			}
			for(int j = 1; j < n - 1 ; j ++) { //남규
				for(int k = 1; k < n - 1; k++) { //영훈
					if(j < k + 2) {
						continue;
					}
					
					if(i + j + k == n) {
						sum += 1;
					}
					
				}
			}
		}
		System.out.println(sum);
	}
}
