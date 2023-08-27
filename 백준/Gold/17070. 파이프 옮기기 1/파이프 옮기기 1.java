import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	int d;
	Point(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][][] visit;
    static int cnt;
    static int[] dx = {0,1,1}; //오른쪽, 오른쪽 아래, 아래
    static int[] dy = {1,1,0};
    static Queue<Point> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[3][n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        bfs(0,1);
        System.out.println(cnt);
        
        
    }
	private static void bfs(int i, int j) {
		q.add(new Point(i,j,0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int d = p.d;
			if(x == n - 1 && y == n - 1) {
				cnt++;
				continue;
			}
			addQueue(x, y, d);
		}
		
	}
	
	private static void addQueue(int x, int y, int d) {
		switch(d) {
		case 0:
			//오른쪽
			checkDist(x, y, 0);
			//대각선
			checkDae(x, y);
			break;
		case 1:
			checkDist(x, y, 0);
			checkDist(x, y, 2);
			checkDae(x, y);
			break;
		case 2:
			checkDist(x, y, 2);
			checkDae(x, y);
			break;
		}
		
	}
	private static void checkDae(int x, int y) {
		int nx;
		int ny;
		boolean tf = true;
		for (int i = 0; i < 3; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(!check(nx, ny)) {
				tf = false;
				break;
			}
		}
		if(tf) {
			nx = x + dx[1];
			ny = y + dy[1];
			q.add(new Point(nx, ny, 1));
		}
	}
	private static void checkDist(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		if(check(nx, ny)){
			q.add(new Point(nx, ny, d));
		}
	}
	
	private static boolean check(int nx, int ny) {
		if(0<= nx && nx < n && 0<= ny && ny < n && arr[nx][ny] == 0) return true;
		return false;
	}
}