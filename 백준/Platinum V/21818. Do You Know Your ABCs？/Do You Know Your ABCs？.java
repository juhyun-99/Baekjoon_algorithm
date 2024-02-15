import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];

			HashSet<Long> set = new HashSet<>(); 
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				set.add(arr[i]);
				for (int j = 0; j < n; j++) {
					if(arr[j] > arr[i])
						set.add(arr[j] - arr[i]);
				}
			}
			
			Iterator<Long> iterator = set.iterator();
			List<Long> list = new ArrayList<>();
			while(iterator.hasNext()) {
				list.add(iterator.next());
			}
			//System.out.println("뽑은거" + list.toString());
			
			int cnt = 0;
			for (int a = 0; a < list.size(); a++) {
				for (int b = 0; b <list.size(); b++) {
					for (int c = 0; c < list.size(); c++) {
						if(list.get(a) <= list.get(b) && list.get(a) <= list.get(c) && list.get(b) <= list.get(c)) {
							long tmpA = list.get(a);
							long tmpB = list.get(b);
							long tmpC = list.get(c);
							
							long[] tmp = {tmpA, tmpB, tmpC, tmpA + tmpB, tmpB + tmpC, tmpA + tmpC, tmpA + tmpB + tmpC};
							//System.out.println(Arrays.toString(tmp));
							int count = 0;
							for (int i = 0; i < n; i++) {
								for (int j = 0; j < 7; j++) {
									if(arr[i] == tmp[j]) {
										count++;
										break;
									}
								}
							}
							if(count == n) {
//								System.out.println(Arrays.toString(arr));
								//System.out.println(Arrays.toString(tmp));
								cnt++;
							}
						}
					}
				}
			}
			if(test == t - 1) {				
				sb.append(cnt);
			}else {
				sb.append(cnt + "\n");
			}
		}
		System.out.println(sb);
	}
}
