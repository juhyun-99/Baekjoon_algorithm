import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n, m;
	static List<Integer>[] stu;
	static boolean[] visit;
	static int[] cnt;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        stu = new ArrayList[n + 1];
        cnt = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
			stu[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	stu[a].add(b);
        	cnt[b]++;
		}
        
        for (int i = 1; i < n + 1; i++) {
			if(!visit[i] && cnt[i] == 0) {
				q.add(i);
				visit[i] = true;
			}
		}
        check();
        System.out.println(sb);
        
    }
    
	private static void check() {
		while(!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp + " ");
			for (int j = 0; j < stu[tmp].size(); j++) {
				int next = stu[tmp].get(j);
				if(!visit[next] && cnt[next] > 0) {
					cnt[next]--;
					if(cnt[next] == 0) {
						visit[next] = true;
						q.add(next);
					}
				}
			}
		}
		
	}
      
}