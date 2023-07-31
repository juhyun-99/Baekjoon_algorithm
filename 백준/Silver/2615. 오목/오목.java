import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //순서대로 아래쪽 세로, 오른쪽 가로, 오른쪽 위, 오른쪽 아래의 방향
        int[] dx = {1, 0, -1, 1};
        int[] dy = {0, 1, 1, 1};

        int[][] board = new int[19][19]; //현재 오목판의 정보를 저장할 배열
        //바둑알의 갯수가 6개 이상이 되는 경우 그 방향의 모든 바둑돌은 정답에서 제외를 해줘야한다.
        boolean[][][] tf = new boolean[4][19][19];//각 방향별로 가능 불가능을 판단할 배열


        //오목판의 정보를 입력받아 저장함
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        int winner = 0; // 승자를 저장할 winner변수
        //승자가 결정났을 경우 승자의 가장 왼쪽 바둑알 좌표를 저장할 x, y 좌표
        int x = 0, y = 0;

        loop:
        //바둑판의 첫번째 칸부터 차례대로 탐색
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (board[i][j] != 0) { //바둑알이 검은색이거나 흰색일 때

                    for (int d = 0; d < 4; d++) { // 세로, 가로, 오른쪽 위, 오른쪽 아래의 방향으로 탐색한다.
                        int cnt = 0; //같은 바둑돌이 몇개인지 저장할 cnt변수
                        int nx = i;
                        int ny = j;
                        //0 <= nx, ny < 19이면서 board[nx][ny] == board[i][j]이고 tf[d][nx][ny]가 false 일 때까지 while 반복문을 돌림
                        while (0 <= nx && nx < 19 && 0 <= ny && ny < 19 && board[nx][ny] == board[i][j] && !tf[d][nx][ny]) {
                            cnt++;
                            //하나의 방향으로 탐색
                            nx += dx[d];
                            ny += dy[d];
                        }

                        if (cnt == 5) { //바둑돌이 5개만 있는 경우
                            winner = board[i][j]; //winner를 저장해주고
                            //그 왼쪽 바둑돌의 좌표를 저장해준다.
                            x = i + 1;
                            y = j + 1;
                            break loop;
                        } else if (cnt > 5) { //만약 바둑돌의 개수가 6개 이상인 경우
                            nx = i;
                            ny = j;
                            // 그 방향의 모든 바둑돌은 정답에서 제외를 시켜준다.
                            while (0 <= nx && nx < 19 && 0 <= ny && ny < 19 && board[nx][ny] == board[i][j]) {
                                tf[d][nx][ny] = true;
                                nx += dx[d];
                                ny += dy[d];
                            }
                        }
                    }
                }
            }
        }

        //정답 출력
        System.out.println(winner);
        if (winner > 0) {
            System.out.printf("%d %d", x, y);
        }
    }
}

