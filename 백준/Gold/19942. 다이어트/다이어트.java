import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {
	static int N;
	static List<String> ansArr = new ArrayList<>();
	static List<String> selFood = new ArrayList<>();
	static int food[][], target[], tmp;
	static boolean visit[], tf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		food = new int[N][5];
		target = new int[4];
		tf = false;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				food[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		tmp = Integer.MAX_VALUE;
		
		recursive(0,0,0,0,0,0,0);
		
		if(tf) {	
			System.out.println(tmp);
			Collections.sort(ansArr);
			System.out.println(ansArr.get(0));
		}else {
			System.out.println(-1);
		}
		
	}

	private static void recursive(int dan, int ji, int tan, int bi, int price, int foods, int cnt) {
		
		
		if(cnt == N) {
			if(dan < target[0] || ji < target[1] || tan < target[2] || bi < target[3] || price > tmp) {
				return;
			}
			
			if(foods == 0) return;
			if(price <= tmp) {
				tf = true;
				if(price < tmp) {
					ansArr.clear();
					tmp = price;
				}
				String s = "";
				for (int i = 0; i < selFood.size(); i++) {
					s+=selFood.get(i);
				}
				ansArr.add(s);
			}
			return;
		}
		
		selFood.add((cnt + 1) + " ");
		recursive(dan +food[cnt][0], ji + food[cnt][1], tan + food[cnt][2], bi + food[cnt][3], price + food[cnt][4], foods + 1, cnt + 1);
		selFood.remove((cnt + 1) + " ");
		recursive(dan, ji , tan, bi, price, foods, cnt + 1);
	}

	
}
