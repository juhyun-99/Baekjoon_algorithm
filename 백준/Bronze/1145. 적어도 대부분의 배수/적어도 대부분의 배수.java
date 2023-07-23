import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[5];
		for(int i = 0; i< 5; i ++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i = 1; i < 1000000; i++) {
			int cnt = 0;
			for(int j = 0; j< 5; j ++) {
				if(i % arr[j] == 0) {
					cnt +=1;
				}
			}
			if(cnt >= 3) {
				System.out.println(i);
				break;
			}
		}

	}
}
