import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			List<String> list = new ArrayList<>();
			HashSet<String> set = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String s = br.readLine();
			for (int i = 0; i < n/4; i++) {
				s += s.charAt(i);
				for (int j = i; j < n + i; j+= n/4) {
					String tmp = "";
					for (int m = j; m < n/4 + j; m++) {
						tmp+= s.charAt(m);
					}
					set.add(tmp);
				}
			}
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				list.add(it.next());
			}
			Collections.sort(list, Collections.reverseOrder());
			//System.out.println(list.toString());
			sb.append("#" + test +" " + Integer.parseInt(list.get(k - 1),16) + "\n");
			
		}
		System.out.println(sb);
	}
}
