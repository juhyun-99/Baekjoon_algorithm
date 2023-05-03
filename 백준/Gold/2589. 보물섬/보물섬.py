import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(n)]

ans = 0
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs(x,y):
    q = deque([])
    q.append((x,y))
    visit = [[0] * m for _ in range(n)]
    visit[x][y] = 1
    ans = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 'L' and visit[nx][ny] == 0:
                visit[nx][ny] = visit[x][y] + 1
                ans = max(ans, visit[nx][ny])
                q.append((nx,ny))
    return ans - 1

for i in range(n):
    for j in range(m):
        if arr[i][j] == 'L':
            ans = max(ans,bfs(i,j))

print(ans)