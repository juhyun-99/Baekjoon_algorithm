import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int t = Integer.parseInt(br.readLine());
    	int[] dx = {1,0,1,1};
    	int[] dy = {0,1,1,-1};
    	
    	for (int test = 1; test <= t; test++) {
    		int n = Integer.parseInt(br.readLine());
    		char[][] arr = new char[n][n];
    		
    		for (int i = 0; i < n; i++) {
    			String s = br.readLine();
    			for (int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
    		
    		String ans = "NO";
    		
    		for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					if(arr[i][j] == 'o') {
						for (int d = 0; d < 4; d++) {
							int cnt = 0;
							int nx = i;
							int ny = j;
							
							while(0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] == 'o') {
								cnt++;
								nx += dx[d];
								ny += dy[d];
							}
							
							if(cnt >= 5) {
								ans = "YES";
							}
						}
					}
				}
			
			}
    		System.out.printf("#%d %s\n",test,ans);   				
		}
    }
}
