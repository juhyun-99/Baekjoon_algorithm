import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	 static int n,r,c,cnt;
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	       
	        /*
	         * 큰거에서 작은거로 나누어 들어가면서 정답을 찾을 수 있다.
	         * 큰 것에서 몇사분면인지 찾고 작은 것으로 들어가면서 각 사분면의 첫번째 값을 더해준다.
	         * 
	         * */
	        
	        n = Integer.parseInt(st.nextToken());
	        r = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        cnt = 0;
	        recursive(r, c, (int)Math.pow(2, n));
	        System.out.println(cnt);
	        
	        
	 }
	private static void recursive(int x, int y, int size) {
		if(size == 1) { //size가 1이면 반으로 나눴을 때 정수가 될 수 없으므로 return
			return;
		}
		int half = size/2;
		if(x < half && y < half) { //1사분면의 제일 왼쪽 위의 값은 0이기 때문에 아무 연산도 하지않고 재귀 호출
			recursive(x, y, half);
		}
		else if(x < half && y >= half) {
			cnt += (size * size)/4 ;
			recursive(x, y - half, half);
		}
		else if(x >= half && y < half) {
			cnt+=(size * size)/2;
			recursive(x - half, y, half);
		}
		else if(x >= half && y >= half) {
			cnt+=(size * size)/4 * 3;
			recursive(x - half, y - half, half);
		}
	}
}
