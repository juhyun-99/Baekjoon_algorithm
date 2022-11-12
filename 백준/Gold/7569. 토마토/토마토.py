from collections import deque
import sys
input = sys.stdin.readline

M, N, H = map(int,input().split())
tomato = [[list(map(int,input().split())) for _ in range(N)] for _ in range(H)]
day = [[[0] * M for _ in range(N)]for _ in range(H)]
q = deque([])
cnt = 0
dx = [1,-1,0,0,0,0]
dy = [0,0,1,-1,0,0]
dz = [0,0,0,0,1,-1]

for i in range(H):
    for j in range(N):
        for k in range(M):
            if tomato[i][j][k] == 1:
                q.append((i, j, k))
                cnt += 1
            elif tomato[i][j][k] == -1:
                cnt += 1
ans = 0
while q:
    z, x, y = q.popleft()
    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]
        if (0 <= nx < N and 0 <= ny < M and 0 <= nz < H) and tomato[nz][nx][ny] == 0:
            tomato[nz][nx][ny] = 1
            day[nz][nx][ny] = day[z][x][y] + 1
            ans = max(ans, day[nz][nx][ny])
            cnt += 1
            q.append((nz,nx,ny))

if cnt != (M * N * H):
    print(-1)
else:
    print(ans)