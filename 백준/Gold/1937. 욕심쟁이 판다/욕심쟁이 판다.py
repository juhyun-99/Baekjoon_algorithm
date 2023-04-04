import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
tmp = [[0] * n for _ in range(n)]

def check(x, y):
    if tmp[x][y]:
        return tmp[x][y]
    tmp[x][y] = 1
    for dx, dy in d:
        nx, ny = x + dx,  y + dy
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        if arr[x][y] < arr[nx][ny]:
            tmp[x][y] = max(tmp[x][y], check(nx, ny) + 1)
    return tmp[x][y]

ans = 0
for i in range(n):
    for j in range(n):
        ans = max(ans, check(i, j))
print(ans)