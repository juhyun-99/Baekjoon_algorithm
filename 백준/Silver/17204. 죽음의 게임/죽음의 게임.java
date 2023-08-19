import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    st = new StringTokenizer(br.readLine());

	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    int arr[] = new int[n];
	    
	    for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	   
	    for (int i = 1; i <= n; i++) {
		    int idx = 0;
		    int num = 1;
	    	while(num <= n) {
	    		if(arr[idx] == k && num == i) {
	    			System.out.println(i);
	    			System.exit(0);
	    		}
	    		num++;
	    		idx = arr[idx];
	    	}
		}
	    System.out.println(-1);
	}
}
