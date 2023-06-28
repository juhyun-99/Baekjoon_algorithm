import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{

    public static void main(String args[]) throws Exception
    {
        
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[][] arr = new int[9][9];
            int ans = 1;

            for (int i = 0; i < 9; i++) {
                boolean[] tf = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                    if(tf[arr[i][j]]){
                        ans = 0;
                    }
                    tf[arr[i][j]] = true;
                }
            }

            for (int i = 0; i < 9; i++) {
                boolean[] tf = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    if(tf[arr[j][i]]){
                        ans = 0;
                    }
                    tf[arr[j][i]] = true;
                }
            }

            for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    boolean[] tf = new boolean[10];
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(tf[arr[i + k][j + l]]){
                                ans = 0;
                            }
                            tf[arr[i + k][j + l]] = true;
                        }
                    }
                }

            }
            System.out.printf("#%d %d\n", test_case, ans);
        }
    }
}