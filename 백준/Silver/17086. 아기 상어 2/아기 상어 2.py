#아기 상어2
import sys; input = sys.stdin.readline
from collections import deque

N, M = map(int,input().split())

graph = []
queue = deque()
for i in range(N):
    temp = list(map(int,input().split()))
    for j in range(M):
        if temp[j] == 1:
            queue.append((i,j))
    graph.append(temp)

dx = [1, -1, 0, 0, 1, 1, -1, -1]
dy = [0, 0, 1, -1, 1, -1, 1, -1]

def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if graph[nx][ny] == 0:
                    queue.append((nx, ny))
                    graph[nx][ny] = graph[x][y] + 1

    return
bfs()
cnt = 0
for i in range(N):
    for j in range(M):
        cnt = max(cnt, graph[i][j])

print(cnt - 1)

