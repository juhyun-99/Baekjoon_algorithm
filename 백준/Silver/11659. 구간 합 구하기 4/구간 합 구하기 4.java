import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[n + 1];
		sum[0] = 0;
		sum[1] = arr[1];
		
		for (int i = 2; i < arr.length; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 =  Integer.parseInt(st.nextToken()) - 1;
			int num2 =  Integer.parseInt(st.nextToken());
			sb.append(sum[num2] - sum[num1] + "\n");
		}
		System.out.println(sb);
	}
}