import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		
		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(br.readLine());
			boolean tf = true;
			for (int j = 2; j < 1_000_000 ; j++) {
				if(num % j == 0) {
					System.out.println("NO");
					tf = false;
					break;
				}
			}
			if(tf) {
				System.out.println("YES");
			}

		}
	}
}
