
T = int(input())
def dfs(i, num):
    global s
    visit[i] = 1
    s = max(num, s)
    for j in arr[i]:
        if visit[j] == 0:
            dfs(j, num + 1)
            visit[j] = 0

for tc in range(1, T + 1):
    N, M = map(int, input().split())

    arr = [[] for _ in range(N + 1)]
    for i in range(M):
        x, y = map(int, input().split())
        arr[x].append(y)
        arr[y].append(x)

    s = 0
    for i in range(1, N + 1):
        visit = [0] * (N + 1)
        dfs(i, 1)


    print(f'#{tc} {s}')
