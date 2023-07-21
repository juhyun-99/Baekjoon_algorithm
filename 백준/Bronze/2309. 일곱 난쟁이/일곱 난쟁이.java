import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[9];
		int sum = 0;
		for(int i = 0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		int index1 = 0;
		int index2 = 0;
		for(int i = 0; i<8; i++) {
			for(int j = i + 1; j< 9; j++) {
				if(sum - arr[i] - arr[j] == 100) {
					index1 = i;
					index2 = j;
				}
			}
		}
		
		int cnt = 0;
		int ans[] = new int[7];
		for(int i = 0; i<9; i++) {
			if (i == index1 || i == index2) {
				continue;
			}
			ans[cnt] = arr[i];
			cnt += 1;
		}
		
		Arrays.sort(ans);
		
		for(int i = 0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
