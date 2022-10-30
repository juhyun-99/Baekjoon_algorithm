n, m = map(int, input().split())
ans = []

def dfs(cnt):
    if len(ans) == m:
        print(*ans)
        return

    for i in range(1, n + 1):
        ans.append(i)
        dfs(i + 1)
        ans.pop()

dfs(1)