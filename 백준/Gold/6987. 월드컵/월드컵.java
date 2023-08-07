import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] countries, tmp, sel;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		sel = new int[15][2];
		int idx = 0;
		
		
		//경기를 하는 모든 조합을 구함 15가지
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				sel[idx][0] = i;
				sel[idx][1] = j;
				idx++;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			countries = new int[6][3];// 6개의 나라
			tmp = new int[6][3]; //모든 조합을 보고 점수를 임시 저장할 배열
			ans = 0; //정답 출력할 변수

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < countries.length; j++) {
				countries[j][0] = Integer.parseInt(st.nextToken()); //0 = 승
				countries[j][1] = Integer.parseInt(st.nextToken()); //1 = 무승부
				countries[j][2] = Integer.parseInt(st.nextToken()); //2 = 패
			}

			recursive(0);
			sb.append(ans + " ");
		}
		System.out.println(sb);

	}

	private static void recursive(int idx) {
		// basis part
		if (idx == 15) {
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i][0] != countries[i][0] || tmp[i][1] != countries[i][1] || countries[i][2] != tmp[i][2]) {
					return;
				}
			}
			ans = 1;
			return;
		}

		// inductive part
		
		int first = sel[idx][0];
		int second = sel[idx][1];
		
		//first 승리 second 패배
		tmp[first][0] += 1;
		tmp[second][2] += 1;

		recursive(idx + 1);
		
		tmp[first][0] -= 1;
		tmp[second][2] -= 1;

		// 무
		//first, second 무승부
		tmp[first][1] += 1;
		tmp[second][1] += 1;

		recursive(idx + 1);
		tmp[first][1] -= 1;
		tmp[second][1] -= 1;

		// 패배
		//first 패배 second 승리
		tmp[first][2] += 1;
		tmp[second][0] += 1;
		recursive(idx + 1);
		tmp[first][2] -= 1;
		tmp[second][0] -= 1;
	}
}
