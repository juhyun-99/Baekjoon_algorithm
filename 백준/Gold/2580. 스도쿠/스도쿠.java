import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<Point> zero = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    zero.add(new Point(i, j));
                }
            }
        }

        recursive(0);
    }

    private static void recursive(int cur) {
        if(cur == zero.size()){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        Point p = zero.get(cur);
        for (int i = 1; i < 10; i++) {
            if(!check(i, p)) continue;
            arr[p.x][p.y] = i;
            recursive(cur + 1);
            arr[p.x][p.y] = 0;
        }

    }

    private static boolean check(int num, Point p) {
        int x = p.x;
        int y = p.y;

        //가로
        for (int i = 0; i < 9; i++) {
            if(arr[x][i] == num) return false;
        }

        //세로
        for (int i = 0; i < 9; i++) {
            if(arr[i][y] == num) return false;
        }

        //p가 속해있는 정사각형
        int startX = (p.x / 3) * 3;
        int startY = (p.y / 3) * 3;
//        System.out.println(x + " " + y);
//        System.out.println(startX + " " + startY);
//        System.out.println();

        for (int i = startX; i < startX + 3 ; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if(arr[i][j] == num) return false;
            }
        }
        return true;
    }
}
