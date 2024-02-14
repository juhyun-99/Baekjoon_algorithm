import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] arr;
	static int n;
	static int m;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		v = new boolean[n + 1];
		recursive(0, 1);
		System.out.println(sb);
	}

	private static void recursive(int idx, int m) {
		if(idx == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
				
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n ; i++) {
			if(!v[i]) {
				v[i] = true;
				arr[idx] = i;
				recursive(idx + 1, i + 1);
				v[i] = false;
 			}
		}
	}
	
}
