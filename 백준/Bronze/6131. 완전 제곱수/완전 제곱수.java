import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i = 1; i < 501; i++) {
			for(int j = 1; j< 501; j ++) {
				if(i*i == j*j + n) {
					sum += 1;
				}
			}
		}
		System.out.println(sum);
	}
}
