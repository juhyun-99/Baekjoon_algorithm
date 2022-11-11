import sys
from collections import deque
input = sys.stdin.readline
M, N = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]
day = [[0] * M for _ in range(N)]
visit = [[0] * M for _ in range(N)]

q = deque([])
cnt = 0
ans = 0

for i in range(N):
    for j in range(M):
        if arr[i][j] == 1: # 시작 토마토들이 들어간다.
            q.append((i, j))
            visit[i][j] = 1
            cnt = cnt + 1
            day[i][j] = 0
        elif arr[i][j] == -1:
            cnt = cnt + 1

while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 0 and visit[nx][ny] == 0:
            q.append((nx, ny))
            visit[nx][ny] = 1
            cnt = cnt + 1
            day[nx][ny] = day[x][y] + 1
            ans = max(ans, day[nx][ny])

if cnt != N * M:
    print(-1)
else:
    print(ans)

