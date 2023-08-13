import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			int num = 1;
			int dist = 1;
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int pStart = 0;
			int qStart = 0;
			int pLevel = 0;
			int qLevel = 0;
			
			while(num <= p) {
				num+=dist;
				dist++;
				pLevel++;
			}
			pStart = num - pLevel;
			num = 1;
			dist = 1;
			
			while(num <= q) {
				num+=dist;
				dist++;
				qLevel++;
			}
			qStart = num - qLevel;
			
		
			int x1,y1, x2, y2;
			x1 = 1; y1 = pLevel;
			x2 = 1; y2 = qLevel;
			if(p == 1) {
				x1 = 1;
				y1 = 1;
				pStart = 1;
			}
			if(q == 1) {
				x2 = 1;
				y2 = 1;
				qStart = 1;
			}
			
			while(pStart < p) {
				x1++;
				y1--;
				pStart++;
			}
			
			while(qStart < q) {
				x2++;
				y2--;
				qStart++;
			}
			
			int x3 = x1 + x2;
			int y3 = y1 + y2;
			
			num = 1;
			dist = 1;
			int tmpLevel = 0;
			int ansLevel = x3 + y3 - 1;
			int ansStart = 0;
			while(tmpLevel < ansLevel) {
				num+=dist;
				dist++;
				tmpLevel++;
			}
			ansStart = num - ansLevel;
			
			int tmpx = 1; int tmpy = ansLevel;
			while(tmpx < x3) {
				ansStart++;
				tmpx++;
				tmpy--;
			}
			sb.append("#" + test + " " + ansStart + "\n");
		}
		System.out.println(sb);
	}
}
