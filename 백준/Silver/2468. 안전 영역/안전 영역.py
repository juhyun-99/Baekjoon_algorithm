import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input())

#배열
arr = [list(map(int, input().split())) for _ in range(N)]
drown = [[0] * N for _ in range(N)]

#수위
def d(h):
    for i in range(N):
        for j in range(N):
            if arr[i][j] <= h:
                drown[i][j] = 1 #잠김
#dfs
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y, visit):
    visit[x][y] = 1 #방문처리

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < N:
            if visit[nx][ny] == 0 and drown[nx][ny] == 0:
                dfs(nx, ny, visit)
ans = 1
for h in range(1, 101):
    visit = [[0] * N for _ in range(N)]
    cnt = 0
    d(h) #h만큼 비가 왔을 때 잠긴 땅의 정보
    for i in range(N):
        for j in range(N):
            if visit[i][j] == 0 and drown[i][j] == 0:
                dfs(i, j, visit)
                cnt += 1
    ans = max(ans, cnt)




print(ans)




