import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Sepo implements Comparable<Sepo>{
    int x;
    int y;
    int value;
    int time;
    Sepo(int x, int y,int value, int time){
        this.x = x;
        this.y = y;
        this.value = value;
        this.time = time;
    }
    @Override
    public String toString() {
        return "Sepo [x=" + x + ", y=" + y + ", value=" + value + ", time=" + time;
    }
	@Override
	public int compareTo(Sepo o) {
		
		return o.time - this.time;
	}

}

public class Solution {
    static boolean[][] visit;
    static int n,m,k,dist;
    static int[][] arr;
    static Queue<Sepo> q;
    static PriorityQueue<Sepo> pq;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test <= t; test++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            dist = Math.max(n, m) + 2*k;
            visit = new boolean[dist][dist];
            q = new LinkedList<>();
            pq = new PriorityQueue<>();
            cnt = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] != 0) {
                        visit[i + dist/2][j + dist/2] = true;
                        pq.add(new Sepo(i + dist/2, j + dist/2, arr[i][j], arr[i][j] * 2));
                        cnt++;
                    }
                }
            }
            while(!pq.isEmpty()) {
        		Sepo s = pq.poll();
        		q.add(s);
        		//System.out.println(s.toString());
        	}
            bfs();
            System.out.printf("#%d %d\n",test, q.size());
        }
    }
    private static void bfs() {
        for (int i = 1; i <= k; i++) {
        	int size = q.size();
            
            for (int j = 0; j < size; j++) {
                Sepo p = q.poll();
                p.time--; //시간이 지남
                if(p.time < 0) continue;
                if(p.time == p.value - 1) { //자기 초가 됐으면 활성 상태 후 번식
                    //번식을 한다!!!!!
                    for (int k = 0; k < 4; k++) {
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if(0 <= nx && nx < dist && 0 <= ny && ny < dist && !visit[nx][ny]) {
                            visit[nx][ny] = true;
                            pq.add(new Sepo(nx, ny, p.value , p.value * 2));
                        }
                    }
                    p.time-= 1;
                    if(p.time >= 0) pq.add(p);
                    continue;
                }
                
                else if(p.time > p.value - 1 || p.time < p.value - 1) {
                    pq.add(p);
                }
            }
            //System.out.println(i);
        	while(!pq.isEmpty()) {
        		Sepo s = pq.poll();
        		q.add(s);
        		//System.out.println(s.toString());
        	}
        }
        
    }
}