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
	static int n;
	static int[][] arr;
	static boolean[] visitLeft;
	static boolean[] vistRight;
	static int count = 0;
	
	static int ans1 = Integer.MIN_VALUE;
	static int ans2 = Integer.MIN_VALUE;
	static List<int[]> listEven = new ArrayList<>();
	static List<int[]> listOdd = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visitLeft = new boolean[n *2];
		vistRight = new boolean[n * 2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					if((i + j) % 2 == 0) listEven.add(new int[] {i,j});
					else listOdd.add(new int[] {i,j});
				}
			}
		}
		
		recursive1(0, 0);
		recursive2(0, 0);
		System.out.println(ans1 + ans2);
		
	}
	
	private static void recursive1(int idx, int cnt) {
		if(idx == listEven.size()) {
			ans1 = Math.max(ans1, cnt);
			return;
		}
		
		//놓는거
		int x = listEven.get(idx)[0];
		int y = listEven.get(idx)[1];
		
		if(!visitLeft[x + y] && !vistRight[x - y + n]) {			
			visitLeft[x + y] = true;
			vistRight[x - y + n] = true;
			recursive1(idx + 1, cnt + 1);
			visitLeft[x + y] = false;
			vistRight[x - y + n] = false;
		}
		//안놓는거
		recursive1(idx + 1, cnt);
		
	}
	
	private static void recursive2(int idx, int cnt) {
		if(idx == listOdd.size()) {
			ans2 = Math.max(ans2, cnt);
			return;
		}
		
		//놓는거
		int x = listOdd.get(idx)[0];
		int y = listOdd.get(idx)[1];
		
		if(!visitLeft[x + y] && !vistRight[x - y + n]) {			
			visitLeft[x + y] = true;
			vistRight[x - y + n] = true;
			recursive2(idx + 1, cnt + 1);
			visitLeft[x + y] = false;
			vistRight[x - y + n] = false;
		}
		//안놓는거
		recursive2(idx + 1, cnt);
		
	}

}
