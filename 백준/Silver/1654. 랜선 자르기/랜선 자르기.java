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
	    
	    st = new StringTokenizer(br.readLine());
	    int k = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    int[] line = new int[k];
	    long max = Integer.MIN_VALUE;
	    for (int i = 0; i < k; i++) {
			line[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, line[i]);
		}
	    long min = 1;
	    long ans = 0;
	    while(min <= max) {
	    	long mid = (min + max)/2;

	    	long cnt = 0;
	    	for (int i = 0; i < k; i++) {
	    		
	    		 cnt += line[i]/mid;
	    	}
	    	if(cnt >= n) {
	    		ans = Math.max(mid, ans);	    		
	    		min = mid + 1;
	    	}
	    	else if(cnt < n) {
	    		max = mid - 1;
	    	}
	    	
	    }
	    System.out.println(ans);
	}
}
