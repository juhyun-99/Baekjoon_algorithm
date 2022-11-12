from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
ice = [list(map(int, input().split())) for _ in range(N)]
dx = [0,0,1,-1]
dy = [1,-1,0,0]

def bfs(visit):
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M  and ice[nx][ny] == 0 and visit[nx][ny] == 0:
                ice[x][y] -= 1
                if ice[x][y] == 0:
                    break

def c(x,y,vv): #빙하 수 세기
    qq = deque([])
    qq.append((x,y))
    vv[x][y] = 1
    while qq:
        x,y = qq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M  and vv[nx][ny] == 0 and ice[nx][ny] > 0:
                vv[nx][ny] = 1
                qq.append((nx, ny))


year = 0
while True:
    q = deque([])
    visit = [[0] * M for _ in range(N)]
    vv = [[0] * M for _ in range(N)]
    cnt = 0
    cnt0 = 0
    for i in range(N):
        for j in range(M):
            if ice[i][j] > 0 and vv[i][j] == 0:
                c(i,j,vv) #빙하 수 세기
                cnt += 1
            if ice[i][j] == 0:
                cnt0 += 1
    if cnt >= 2:
        break
    if cnt0 == M * N:
        year = 0
        break

    for i in range(N):
        for j in range(M):
            if ice[i][j] > 0:
                visit[i][j] = 1
                q.append((i, j))
    year += 1
    bfs(visit)

print(year)