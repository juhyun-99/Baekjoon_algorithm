import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
    int x;
    int y;
    int d;
    char ans = '*';
    int cnt;
    int sum;
    Point(int x, int y, int d, char ans, int cnt, int sum){
        this.x = x;
        this.y = y;
        this.d = d;
        this.ans = ans;
        this.cnt = cnt;
        this.sum = sum;
    }
}
public class Main {
    static int r;
    static int c;
    static char[][] arr;
    static int sx,sy; //집 좌표
    static int ex,ey; //유치원 좌표
    //우, 하, 좌, 상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int ansx, ansy; //.이었던 길의 좌표를 저장할 변수
    static char ansChar; //.이었던 길을 어떤 길로 변경했을 때 그 변경한 길을 저장할 변수
    static int cnt;
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new char[r][c];
            
            
            for (int i = 0; i < r; i++) {
                arr[i] = br.readLine().toCharArray();
                for (int j = 0; j < c; j++) {
                    if(arr[i][j] == 'M') {//집 일때
                        sx = i; sy = j; //집 좌표 저장
                    }else if(arr[i][j] == 'Z') {//유치원일때
                        ex = i; ey = j; //유치원 좌표 저장
                    }
                    if(arr[i][j] !='.') {
                    	if(arr[i][j] == '+') {
                    		cnt++;
                    	}
                        cnt++; //지나갈 길 갯수 저장
                    }
                }
            }
            cnt-=2;
            //System.out.println(cnt);
            bfs();
            System.out.printf("%d %d %c\n" ,ansx, ansy, ansChar);

    }
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            //집은 하나의 블록과 인접해있는 입력만 주어지기 때문에
            //우, 하, 좌, 상
            int d = 0;
            if(0 <= nx && nx < r && 0<= ny && ny < c) { //가장 처음 집에서 연결되어 있는 길과 방향을 확안해서 큐에 넣어준다.
                if(arr[nx][ny] != '.') {
                	if(i == 0) {
                		if(arr[nx][ny] == '-' || arr[nx][ny] =='+') d = i;
                		else if(arr[nx][ny] == '3') d = 3;
                		else if(arr[nx][ny] == '4') d = 1;
                	}else if(i == 1) {
                		if(arr[nx][ny] == '|' || arr[nx][ny] =='+') d = i;
                		else if(arr[nx][ny] == '2') d = 0;
                		else if(arr[nx][ny] == '4') d = 2;
                	}else if(i == 2) {
                		if(arr[nx][ny] == '-' || arr[nx][ny] =='+') d = i;
                		else if(arr[nx][ny] == '1') d = 1;
                		else if(arr[nx][ny] == '2') d = 3;
                	}else {
                		if(arr[nx][ny] == '|' || arr[nx][ny] =='+') d = i;
                		else if(arr[nx][ny] == '1') d = 0;
                		else if(arr[nx][ny] == '4') d = 2;
                	}
                    q.add(new Point(nx, ny, d,'*', 0, 1));
                    break;
                }
            }
        }
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            //System.out.printf("%d %d %c %c %d %d\n",p.x, p.y, arr[p.x][p.y], p.ans,p.cnt,p.sum);
            
            if(p.x == ex && p.y == ey) {
                if(p.ans != '*') {
                    if(p.ans =='+') {// +일때는 같은 좌표를 2번 가야하기 때문에
                        if(p.cnt == 2 && p.sum == cnt) { //2번 방문했는지 체크하고 2번 방문했고 지나간 길 갯수가 같을 때
                            ansChar = p.ans;//정답을 저장하고 break
                            break;                            
                        }
                    }else { //+가 아닐 때는 정답 저장하고  break
                        if(p.sum == cnt) { //지나간 길 갯수가 같을때
                            ansChar = p.ans;
                            break;                            
                        }
                    }
                    
                }
            }

            //현재 방향 좌표 저장
            int nx = p.x + dx[p.d];
            int ny = p.y + dy[p.d];
            
            //배열의 범위를 벗어나면 continue;
            if(!(0 <= nx && nx < r && 0<= ny && ny < c)) continue;
            
            int direct = 0;
            
            //다음 방향 좌표의 값 확인
            switch(arr[nx][ny]) {
            case 'Z':
                q.add(new Point(nx, ny, p.d, p.ans, p.cnt, p.sum));
                break;
            
            
            case '.': //길의 중간에 .이 있으면
                //일단 모든 길을 넣어보는 것으로 생각을 했음.
                //모든 길을 넣어보고 유치원까지 갈 수 있는지를 확인해서 그때 넣은 그 길을 정답으로 출력해준다.
                //단 +일때는 두 번 건넜는지 확인해야한다.
                //우, 하, 좌, 상
                if(p.cnt == 0) {                    
                    ansx = nx + 1; ansy = ny + 1;//비어있는 길의 좌표를 저장한다.
                    q.add(new Point(nx, ny, p.d, '+', 1, p.sum)); //+는 모든 방향에서 갈 수 있음.
                    if(p.d == 0) {//오른쪽이었으면은
                        q.add(new Point(nx, ny, p.d, '-', 1, p.sum)); //-길은 그대로 오른쪽으로 가고
                        //그 전 방향이 오른쪽이었을 상황일때 갈 수 있는 길을 넣어주고 이 길을 지날 때 방향을 바꿔서 큐에 넣어준다.
                        q.add(new Point(nx, ny, 3, '3', 1, p.sum)); 
                        q.add(new Point(nx, ny, 1, '4', 1, p.sum)); 
                    }
                    if(p.d == 1) {//아래쪽이었을 때
                        q.add(new Point(nx ,ny, p.d, '|', 1, p.sum)); //|길은 그대로 가고
                        //그 전 방향이 아래쪽이었을 상황일때 갈 수 있는 길을 넣어주고 이 길을 지날 때 방향을 바꿔서 큐에 넣어준다.
                        q.add(new Point(nx, ny, 0, '2', 1, p.sum)); 
                        q.add(new Point(nx, ny, 2, '3', 1, p.sum));
                    }
                    if(p.d == 2) {//왼쪽이었을 때
                        q.add(new Point(nx, ny, p.d, '-', 1, p.sum));
                        //그 전 방향이 왼쪽이었을 상황일때 갈 수 있는 길을 넣어주고 이 길을 지날 때 방향을 바꿔서 큐에 넣어준다.
                        q.add(new Point(nx, ny, 1, '1', 1, p.sum));
                        q.add(new Point(nx, ny, 3, '2', 1, p.sum));
                    }
                    if(p.d == 3) {//위쪽이었을 때
                        q.add(new Point(nx ,ny, p.d, '|', 1, p.sum));
                        //그 전 방향이 위쪽이었을 상황일때 갈 수 있는 길을 넣어주고 이 길을 지날 때 방향을 바꿔서 큐에 넣어준다.
                        q.add(new Point(nx, ny, 0, '1', 1, p.sum));
                        q.add(new Point(nx, ny, 2, '4', 1, p.sum));
                    }
                }else if(p.cnt == 1 && p.ans == '+') {//만약에  + 이고 이미 한번 지나왔던 곳이라면은
                    if(nx == ansx-1 && ny == ansy - 1) { //저장된 좌표랑 같은 좌표인지 확인
                        q.add(new Point(nx, ny, p.d, '+', 2, p.sum)); //p.cnt를 2로해서 넣어준다. == 2번 지남
                    }
                }
                break;
            case '+' : case '|': case '-': //+, |, -일때는 그 전 방향 그대로 지나감
                direct = p.d;
                q.add(new Point(nx, ny, direct,p.ans ,p.cnt, p.sum + 1));
                break;
            //단 길이 1,2,3,4일때는 그 전 방향이 어떤 방향이었는지 따라서 방향이 바뀌기 때문에 방향을 바꿔서 넣어준다.
            case '1':
                if(p.d == 3) direct = 0; //상 -> 우
                if(p.d == 2) direct = 1; //좌 -> 하
                q.add(new Point(nx, ny, direct,p.ans , p.cnt, p.sum + 1));
                break;
            case '2' :
                if(p.d == 1) direct = 0; //하 -> 우
                if(p.d == 2) direct = 3; //좌 -> 위
                q.add(new Point(nx, ny, direct,p.ans , p.cnt, p.sum + 1));
                break;
            case '3':
                if(p.d == 0) direct = 3; //우 -> 위
                if(p.d == 1) direct = 2; //하 -> 좌
                q.add(new Point(nx, ny, direct,p.ans , p.cnt, p.sum + 1));
                break;
            case '4':
                if(p.d == 0) direct = 1; //우 -> 하
                if(p.d == 3) direct = 2; //상 -> 좌
                q.add(new Point(nx, ny, direct,p.ans , p.cnt, p.sum + 1));
                break;
                
            }
            
        }
    }
}