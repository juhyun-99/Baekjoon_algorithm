import sys
from collections import deque
input = sys.stdin.readline

t = int(input())

dx = [-2, -2, -1, 1, 2, 2, 1, -1]
dy = [1, -1, -2, -2, -1, 1, 2, 2]
def bfs(start):
    q = deque([])
    q.append(start)
    visit[start[0]][start[1]] = 1

    while q:
        x, y = q.popleft()
        if x == end[0] and y == end[1]:
            print(visit[x][y] - 1)
            break
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx <l and 0<=ny< l and visit[nx][ny] == 0:
                visit[nx][ny] = visit[x][y] + 1
                q.append([nx, ny])

for _ in range(t):
    l = int(input())
    start = list(map(int,input().split()))
    end = list(map(int,input().split()))
    visit = [[0] * l for _ in range(l)]
    bfs(start)