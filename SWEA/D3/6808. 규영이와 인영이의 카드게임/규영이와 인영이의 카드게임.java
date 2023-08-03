import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int lose, win;
	static boolean[] visit;
	static int[] inyoung, kuyoung;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		/*
		 18장의 카드로 게임을 함
		 9장씩 나눠가짐 
		 9라운드
		 한 장씩 카드를 내고 두사람이 낸 카드에 적힌 수를 비교해서 점수를 계산함.
		 높은카드 적힌 사람 = 두 카드의 합만큼 점수
		 낮은카드 적힌 사람 = 점수 없음
		 총점이 높은 사람이 승자
		 총점 같으면 무승부
		 규영이 카드 주어짐 인영이는 어떻게 낼까
		 9!가지 순서 
		 * */
		
		for(int test = 1; test < t + 1  ; test++) {
			visit = new boolean[19];
			kuyoung = new int[9];
			inyoung = new int[9];
			lose = 0;
			win =  0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < kuyoung.length; i++) {
				kuyoung[i] = Integer.parseInt(st.nextToken());
				visit[kuyoung[i]] = true;
			}
			recursive(0);
			sb.append("#" + test+ " " + win + " " + lose + "\n");
		}
		System.out.println(sb);
		
	}
	private static void recursive( int idx) {
		if(idx == 9) {
			//System.out.println(Arrays.toString(inyoung));
			int inSum = 0;
			int kuSum = 0;
			for (int i = 0; i < inyoung.length; i++) {
				if(inyoung[i] < kuyoung[i]) {
					kuSum+=(inyoung[i] + kuyoung[i]);
				}else if(inyoung[i] > kuyoung[i]){
					inSum+=(inyoung[i] + kuyoung[i]);
				}
			}
			if(inSum > kuSum) lose++;
			else if(inSum < kuSum) win++;
			
			return;
		}
		
		for (int i = 1; i < visit.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				inyoung[idx] = i;
				recursive(idx + 1);
				visit[i] = false;
			}
		}
	}
}
