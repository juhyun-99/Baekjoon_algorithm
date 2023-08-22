import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[][] magnet;
    static int[][] arr;
    static int[] turn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test <= t; test++) {
            int k = Integer.parseInt(br.readLine());
            magnet = new int[4][8];
            arr = new int[4][2];//2번 날, 6번 날 정보 저장할 배열
            //2-6, 2-6, 2-6
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                    if(j == 2) arr[i][0] = magnet[i][j];
                    else if(j == 6) arr[i][1] = magnet[i][j];
                }
            }
            int cnt = 0;
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken());
                turn = new int[4];
                turn(c, r);
                for (int j = 0; j < 4; j++) {
					if(turn[j] != 0) {
						turnArr(j, turn[j]);
					}
				}
                for (int j = 0; j < 4; j++) {
                	arr[j][0] = magnet[j][2];
                	arr[j][1] = magnet[j][6];
                }
//                System.out.println(i+1 + " " + Arrays.toString(turn));
//                for (int j = 0; j < 4; j++) {
//					System.out.println(j+1 +" " +Arrays.toString(magnet[j]));
//				}
//                System.out.println();
            }
            
            for (int j = 0; j < 4; j++) {
            	if(magnet[j][0] == 1) {
            		if(j == 0) {
            			cnt+=1;
            		}else if(j == 1) {
            			cnt += 2;
            		}else if(j == 2) {
            			cnt += 4;
            		}else {
            			cnt += 8;
            		}
            	}
			}
            
            System.out.println("#" + test + " " + cnt );
        }
    }
	private static void turn(int c, int r) {
		turn[c] = r;//현재 방향 저장
		int idx = c;
		for (int j = c-1; j >= 0; j--) {
		    if(arr[idx][1] != arr[j][0]) {
		    	idx = turnLeftRight(idx, j);
		    }else break;
		    
		}
		idx = c;
		for (int j = c + 1; j < 4; j++) {
			if(arr[idx][0] != arr[j][1]) {
		    	idx = turnLeftRight(idx, j);
		    }else break;
		}
	}
	private static int turnLeftRight(int idx, int j) {
		int d = 0;
		if(turn[idx] == 1) d = -1;
		else d = 1;
		
		turn[j] = d;
		return j;
	}
	
	private static void turnArr(int idx, int r) {
		if(r == 1) {//시계
			int tmp = magnet[idx][7];
			for (int j = 7; j >= 1; j--) {
                magnet[idx][j] = magnet[idx][j - 1];
            }
			magnet[idx][0] = tmp;
		}
		else { //반시계
			int tmp = magnet[idx][0];
			for (int j = 0; j < 7; j++) {
                magnet[idx][j] = magnet[idx][j + 1];
            }
			magnet[idx][7] = tmp;
		}
		
	}
}