from collections import deque

import sys
sys.setrecursionlimit(10**6)
M, N = map(int,input().split())

arr = [list(input()) for _ in range(M)]
visit = [[0] * N for _ in range(M)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]

ans = 'NO'

def dfs(x, y):
    global ans
    visit[x][y] = 1
    if x == (M - 1):
        ans = 'YES'
        return

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < M and 0 <= ny < N:
            if visit[nx][ny] == 0 and arr[nx][ny] == '0':
                dfs(nx, ny)

def bfs(x, y):
    global ans
    q = deque()
    q.append((x, y))
    visit[x][y] = 1

    while q:
        x, y = q.popleft()
        if x == (M - 1):
            ans = 'YES'
            return
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                if visit[nx][ny] == 0 and arr[nx][ny] == '0':
                    q.append((nx, ny))
                    visit[nx][ny] = 1


for i in range(N):
    if arr[0][i] == '0' and visit[0][i] == 0:
        bfs(0, i)

print(ans)