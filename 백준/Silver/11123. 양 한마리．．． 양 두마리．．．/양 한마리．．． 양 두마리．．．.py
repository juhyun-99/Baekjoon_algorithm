import sys
from collections import deque
input = sys.stdin.readline
T = int(input())

dx = [1,-1,0,0]
dy = [0,0,1,-1]
def bfs(a, b):
    q.append((a,b))
    visit[a][b] = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < H and 0 <= ny < W and visit[nx][ny] == 0 and arr[nx][ny] == '#':
                q.append((nx, ny))
                visit[nx][ny] = 1

for _ in range(T):
    H, W = map(int, input().split())
    arr = [list(input().rstrip()) for _ in range(H)]
    visit = [[0] * W for _ in range(H)]
    q = deque()
    cnt = 0
    for i in range(H):
        for j in range(W):
            if arr[i][j] == '#' and visit[i][j] == 0:
                bfs(i,j)
                cnt += 1
    print(cnt)
