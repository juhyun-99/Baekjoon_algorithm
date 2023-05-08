tc = int(input())

def dfs(i, cnt):
    global ans
    visit[i] = True
    ans = max(ans, cnt)
    for j in graph[i]:
        if not visit[j]:
            dfs(j, cnt + 1)
            visit[j] = False
for t in range(tc):
    n, m = map(int,input().split())
    arr = [0] * (n + 1)
    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        x, y = map(int,input().split())
        graph[x].append(y)
        graph[y].append(x)
    ans = 0
    for i in range(1, n + 1):
        visit = [False] * (n + 1)
        dfs(i, 1)

    print(f'#{t + 1} {ans}')