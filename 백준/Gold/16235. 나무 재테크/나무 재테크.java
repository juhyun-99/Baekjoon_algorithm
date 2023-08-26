import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static int[][] nutrition;
	static int[][] add;
	static int[] dx = {0,1,0,-1,1,-1,1,-1};
	static int[] dy = {1,0,-1,0,1,1,-1,-1};
	static Deque<Integer>[][] trees;
	static Deque<Integer>[][] tmp;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); //나무 수
		k = Integer.parseInt(st.nextToken());

		nutrition = new int[n][n];
		add = new int[n][n];
		trees = new Deque[n][n];
		tmp = new Deque[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				nutrition[i][j] = 5;
				trees[i][j] = new ArrayDeque<>();
				tmp[i][j] = new ArrayDeque<>();
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < m; i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken())-1;
			 int y = Integer.parseInt(st.nextToken())-1;
			 int v = Integer.parseInt(st.nextToken());
			 trees[x][y].add(v);
		}
		
		cnt = m;
		
		for (int i = 1; i <= k; i++) {
			springAndSummer();
			fallAndWinter();
		}
		System.out.println(cnt);
	}
	
	private static void springAndSummer() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int nutri = 0;
				int size = trees[i][j].size();
				for(int k = 0; k < size; k++) {
					int num = trees[i][j].pollFirst();
					if(nutrition[i][j] - num>= 0) { //양분이 있다면
						nutrition[i][j] -= num;
						trees[i][j].add(num+1);
					}
					else {
						nutri += (num/2); //죽은 나무의 양분
						cnt--;
					}
				}
				
				nutrition[i][j] += nutri; //죽은 나무의 양분을 더해주기
			}
		}
		
	}
	
	private static void fallAndWinter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				int size = trees[i][j].size();
				for(int k = 0; k < size; k++) {
					int num = trees[i][j].pollFirst();
					tmp[i][j].add(num);
					if(num % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if(0<= nx && nx < n && 0<= ny && ny < n) {
								tmp[nx][ny].addFirst(1);
								cnt++;
							}
						}	
					}
	
				}
				nutrition[i][j] += add[i][j]; // 양분 추가
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				while(!tmp[i][j].isEmpty()) {
					trees[i][j].add(tmp[i][j].pollFirst());
				}
			}
		}
	}


}
