import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] arr;
	static int[] robot;
	static int zero;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        /*
         	길이가 n인 컨베이어 벨트가 있음.
         	2n인 벨트가 위 아래를 감싸며 돌고 있다.
         	1~ 2n-1까지는 다음 칸으로 이동 i번칸의 내구도는 ai이다.
         	1 = 올리는 위치 ,<- 여기에만 로봇을 올릴 수 있다.
         	n번 = 내리는 위치
         	로봇이 어떤 칸으로 이동하면 그 칸의 내구도는 1 감소함
         */
        arr = new int[n * 2];
        robot = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        int ans = 1;

        while(true) {
        	rotateBeltAndRobot();
        	moveRobot();
        	putRobot();
        	if(zero >= k) break;
        	ans++;
        }
        System.out.println(ans);
        
	}
	private static void moveRobot() {
		for (int i = n - 1; i > 0 ; i--) {
			if(robot[i - 1] == 1) {//내 앞에 로봇이 있을 때		
				if(arr[i] > 0 && robot[i] == 0) { //내구도가 있고 로봇이 없을 때
					arr[i]-=1; //내구도 감소
					if(arr[i] == 0) zero++; //내구도가 0이면 k감소
					robot[i] = 1;  //robot 이동
					robot[i - 1] = 0;
					if(i == n - 1) robot[i] = 0; //로봇이 n-1번째이면 바로 내림.
				}
			}
		}
		
	}
	private static void putRobot() {
		if(arr[0] > 0) {
			robot[0] = 1;
			arr[0]-=1;
			if(arr[0] == 0) zero++;
		}
	}
	private static void rotateBeltAndRobot() {
		int tmp = arr[n * 2 - 1];
		//컨베이어 벨트 이동
		for (int i = n * 2 - 1; i >= 1 ; i--) {
			arr[i] = arr[i - 1];
		}
		
		for (int i = n - 1; i >= 1; i--) {
			if(i == n - 1) {
				robot[i] = 0;
			}
			else {				
				robot[i] = robot[i - 1];
			}
		}
		arr[0] = tmp;
		robot[0] = 0;	
	}
}
