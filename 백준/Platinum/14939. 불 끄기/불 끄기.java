import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr, copyArr;
    static int calc, ans = Integer.MAX_VALUE;
    static boolean[] swit = new boolean[10];
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, 1, 0, -1, 0};
    static int on = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[10][10];
        copyArr = new char[10][10];
        /*
        * 전체를 끄고 켜보는걸 하는 경우의 수는 너무 많음 2^(10*10) => 시초
        * 내 주변에 가장 많이 켜진걸 꺼보자 -> 내 주변만 켜져있고 나는 꺼져있을 때 : 나를 키면 나는 다시 못끄게 됨.
        *
        * 한 전구를 바꾸면 상하좌우에 영향을 줌.
        * 1번 째 줄의 상태가 전 라인의 끌지 안끌지 영향을 줌. 첫째 줄의 모든 경우로 탐색
        *
        *
        * */
        for (int i = 0; i < 10; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 10; j++) {
                arr[i][j] = tmp.charAt(j);
                copyArr[i][j] = arr[i][j];
            }
        }
        recursive(0);

        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        System.out.println(ans);
    }

    private static void recursive(int cur) {
        if(cur == 10){
            on = 0;
            if(!check()) return;
            ans = Math.min(ans, on);
            return;
        }

        swit[cur] = true;
        recursive(cur + 1);
        swit[cur] = false;
        recursive(cur + 1);
    }

    private static boolean check() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < 10; i++) {
            if(swit[i]){
                on++;
                for (int j = 0; j < 5; j++) {
                    int nx = 0 + dx[j];
                    int ny = i + dy[j];
                    if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
                    copyArr[nx][ny] = copyArr[nx][ny] == '#' ? 'O': '#';
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(copyArr[i - 1][j] == 'O'){
                    on++;
                    for (int k = 0; k < 5; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
                        copyArr[nx][ny] = copyArr[nx][ny] == '#' ? 'O': '#';
                    }
                }
            }
        }

        //다 꺼졌는지 확인
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(copyArr[i][j] == 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}
