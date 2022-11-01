from collections import deque
T = int(input())
dx = [0, 1, 1, 1]
dy = [1, 0, 1, -1]

for tc in range(1, T + 1):
    N = int(input())
    arr = [list(input()) for _ in range(N)]
    result = 'NO'
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 'o':
                for k in range(4):
                    x,y,cnt = i,j,0
                    while 0<= x < N and 0<= y < N and arr[x][y] == 'o':
                        cnt += 1
                        x += dx[k]
                        y += dy[k]
                    if cnt >= 5:
                        result = 'YES'

    print(f'#{tc} {result}')
