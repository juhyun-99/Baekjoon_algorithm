import sys
input = sys.stdin.readline

def recur(x, y):
    if dp[x][y] != -1:
        return dp[x][y]

    cnt = 0
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y

        if 0 <= nx < m and 0 <= ny < n:
            if arr[x][y] > arr[nx][ny]:
                cnt += recur(nx, ny)

    dp[x][y] = cnt
    return dp[x][y]


dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

m, n = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(m)]
dp = [[-1] * n for _ in range(m)]

dp[m - 1][n - 1] = 1
print(recur(0, 0))
