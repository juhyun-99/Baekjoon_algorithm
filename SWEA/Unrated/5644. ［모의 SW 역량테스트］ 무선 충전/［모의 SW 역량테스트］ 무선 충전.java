import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    //안움직, 상 우 하 좌
    static int[] dx = {0,-1,0,1,0};
    static int[] dy = {0,0,1,0,-1};
    static int m,a;
    static int A[], B[];
    static int[][] bc;
    static int ax, ay;
    static int bx, by;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test <= t; test++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            A = new int[m + 1];
            B = new int[m + 1];
            bc = new int[a][4];
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < m + 1; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < m + 1; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            ax = ay = 1;
            bx = by = 10;

            for (int i = 0; i < a ; i++) {
                st = new StringTokenizer(br.readLine());
                bc[i][1] = Integer.parseInt(st.nextToken());
                bc[i][0] = Integer.parseInt(st.nextToken());
                bc[i][2] = Integer.parseInt(st.nextToken());
                bc[i][3] = Integer.parseInt(st.nextToken());
            }


            for (int idx = 0; idx < m + 1; idx++) {
                ax += dx[A[idx]];
                ay += dy[A[idx]];
                bx += dx[B[idx]];
                by += dy[B[idx]];
                int tmp = 0;

                for (int i = 0; i < a; i++) {
                    int distA = (Math.abs(ax - bc[i][0]) + Math.abs(ay - bc[i][1])) <= bc[i][2] ? bc[i][3] : 0;
                    for (int j = 0; j < a; j++) {
                        int distB = (Math.abs(bx - bc[j][0]) + Math.abs(by - bc[j][1])) <= bc[j][2] ? bc[j][3] : 0;
                        if(i == j) {
                            tmp =  Math.max(tmp, Math.max(distA, distB));
                        }
                        else {
                            tmp = Math.max(distA + distB, tmp);
                        }

                    }
                }
                cnt += tmp;
            }
            sb.append("#" + test + " " + cnt + "\n");

        }
        System.out.println(sb);
    }
}
