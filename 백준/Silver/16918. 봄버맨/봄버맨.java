import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, n;
    static char[][] arr;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int size = 0;
    static int[][] boom;
    static int[][] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        boom = new int[r][c];
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if(arr[i][j] == 'O'){
                    boom[i][j] = 3;
                }
                else if(arr[i][j] == '.'){
                    boom[i][j] = -1;
                }
            }
        }

        for (int t = 1; t <= n ; t++) {
        	//print();
            
        	if(t == 1){
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if(boom[i][j] > 0){
                            boom[i][j]-= 1;
                        }
                    }
                }
                continue;
            }

            if(t % 2 == 0){
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if(boom[i][j] > 0){
                            boom[i][j]-= 1;
                        }
                        else if(boom[i][j] == -1){
                            boom[i][j] = 3;
                            arr[i][j] = 'O';
                        }
                    }
                }
            }
            else{
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (boom[i][j] > 0) {
                            boom[i][j] -= 1;
                        }
                    }
                }
                temp = new int[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (boom[i][j] == 0) {
                            temp[i][j] = 1;
                            for (int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if(0<=nx && nx < r && 0<=ny && ny < c){
                                    temp[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if(temp[i][j] == 1){
                            boom[i][j] = -1;
                            arr[i][j] = '.';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(arr[i][j]);
 
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
	private static void print() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}