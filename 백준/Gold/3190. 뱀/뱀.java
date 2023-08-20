import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
					//오른쪽, 아래, 왼쪽, 위
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(br.readLine());
	    int k = Integer.parseInt(br.readLine());
	    int[][] arr = new int[n][n];
	    for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			arr[x][y] = 2; //사과 2
		}
	    arr[0][0] = 1;
	    int l = Integer.parseInt(br.readLine());
	    int[] turn = new int[l];
	    char[] DL = new char[l];
	    for (int i = 0; i < l; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	turn[i] = Integer.parseInt(st.nextToken());
	    	DL[i] =  st.nextToken().charAt(0);
		}
	    int time = 0;
	    int turnIdx = 0;
	    int d = 0;
	    Deque<int[]> deque = new ArrayDeque<>();
	    deque.add(new int[] {0,0});
	    arr[0][0] = 1;
	    while(true) {
	    	if(turnIdx < l) {	    		
	    		if(time == turn[turnIdx]) {
	    			if(DL[turnIdx] == 'D') {
	    				d = (d + 1)%4;	    			
	    			}
	    			else {
	    				d = (d - 1 + 4)%4;	   
	    			}
	    			turnIdx++;
	    		}
	    	}
	    	int[] tmp = deque.peekFirst(); //머리의 좌표 가져옴.
	    	int nx = tmp[0] + dx[d];
	    	int ny = tmp[1] + dy[d];
	    	if(nx < 0 || nx >= n || ny < 0 || ny >= n) break; //머리의 다음좌표 확인
	    	if(arr[nx][ny] == 1) break; //내 몸이면 멈춤.
	    	
	    	deque.addFirst(new int[] {nx, ny}); //사과가 있던 없던 머리는 이동하기 때문에 머리 넣어줌.
	    	if(arr[nx][ny] == 0) { //사과가 없었으면 꼬리 빼줌.
	    		int[] pop = deque.pollLast();
	    		arr[pop[0]][pop[1]] = 0;
	    	}
	    	arr[nx][ny] = 1; //머리 방문체크
	    	
	    	time++;
	    	
	    }
	    System.out.println(time + 1);
	}
}
