import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Point implements Comparable<Point> {
    int x;
    int cnt;
    Point(int x, int cnt){
        this.x = x;
        this.cnt = cnt;
    }
	@Override
	public int compareTo(Point o) {
		
		return Integer.compare(this.cnt, o.cnt);
	}
}
public class Main {
    static int n, m;
    static int[][] arr;
    static List<Point>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(c == 0) {
            	list[start].add(new Point(end, 0));
            	list[end].add(new Point(start, 1));
            }else {

            	list[start].add(new Point(end, 0));
            	list[end].add(new Point(start, 0));
            }
        }

        int cnt = Integer.parseInt(br.readLine());
        bfs();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(arr[start][end]);
        }
        
        System.out.println(sb);
    }
    
    private static void bfs() {
       arr = new int[n + 1][n + 1];
       for (int i = 1; i < n + 1; i++) {
    	   PriorityQueue<Point> q = new PriorityQueue<>();
    	   int[] tmp = new int[n + 1];
    	   Arrays.fill(tmp, Integer.MAX_VALUE);
    	   
    	   q.add(new Point(i, 0));
    	   tmp[i] = 0;
    	   while(!q.isEmpty()) {
    		   Point p = q.poll();
    		   
    		   for(Point next : list[p.x]) {
    			   int cnt = next.cnt + p.cnt;
    			   if(cnt < tmp[next.x]) {
    				   tmp[next.x] = cnt;
    				   q.add(new Point(next.x, cnt));
    			   }
    		   }
    	   }
    	   for (int j = 1; j < n + 1; j++) {
			arr[i][j] = tmp[j];
    	  }
    	   
       }
        
    }
    
}
