import sys; input = sys.stdin.readline
from collections import deque

N = int(input())
graph = [list(input().rstrip()) for _ in range(N)]
visit = [[0]*N for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

#bfs
def bfs(x,y):
    q = deque()
    q.append((x, y))
    visit[x][y] = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if visit[nx][ny] == 0 and graph[x][y] == graph[nx][ny]:
                    visit[nx][ny] = 1
                    q.append((nx, ny))

#적록색약 x
cnt = 0
for i in range(N):
    for j in range(N):
        if visit[i][j] == 0:
            bfs(i, j)
            cnt += 1

# 색 바꾸기 R -> G
for i in range(N):
    for j in range(N):
        if graph[i][j] == 'R':
            graph[i][j] ='G'

#적록색약 O
cnt2 = 0
visit = [[0]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if visit[i][j] == 0:
            bfs(i, j)
            cnt2 += 1
#답 출력
print(cnt, cnt2)
