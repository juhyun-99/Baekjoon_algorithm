import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(br.readLine());
	    int[] num = new int[n];
	    st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < n; i++) {
	    	num[i] = Integer.parseInt(st.nextToken());
	    }
	    int m = Integer.parseInt(br.readLine());

	    int[] num2 = new int[m];
	    st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < m; i++) {
	    	num2[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(num);
	    int[] ans = new int[m];

	    for (int i = 0; i < m; i++) {
			int start = 0;
			int end = n - 1;
			while(start <= end) {
				int mid = (start + end) / 2;

				if(num2[i] == num[mid]) {
					ans[i] = 1;
					break;
				}else if(num2[i] < num[mid]) {
					end = mid - 1;
				}else if(num2[i] > num[mid]) {
					start = mid + 1;
				}
			}
			
		}
	    for (int i = 0; i < m; i++) {
			sb.append(ans[i] + " ");
		}
	    System.out.println(sb);
	    
	}
}
