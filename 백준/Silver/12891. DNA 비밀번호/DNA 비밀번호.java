import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		char[] arr= br.readLine().toCharArray();
		int[] target = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < target.length; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		int[] contains = new int[4];
		int ans = 0;
		
		for (int i = 0; i < p; i++) {
			switch(arr[i]) {
			case 'A':contains[0]++;break;
			case 'C':contains[1]++;break;
			case 'G':contains[2]++;break;
			case 'T':contains[3]++;break;
			}
		}
		if(contains[0] >= target[0] && contains[1] >= target[1] && contains[2] >= target[2] && contains[3]>= target[3]) {
			ans ++;
		}
		for (int i = p; i < s ; i++) {
			switch(arr[i]) {
				case 'A':contains[0]++;break;
				case 'C':contains[1]++;break;
				case 'G':contains[2]++;break;
				case 'T':contains[3]++;break;
			}
			switch(arr[i - p]) {
				case 'A':contains[0]--;break;
				case 'C':contains[1]--;break;
				case 'G':contains[2]--;break;
				case 'T':contains[3]--;break;
			}
			if(contains[0] >= target[0] && contains[1] >= target[1] && contains[2] >= target[2] && contains[3]>= target[3]) {
				ans ++;
			}
		}
		System.out.println(ans);
	}
}
