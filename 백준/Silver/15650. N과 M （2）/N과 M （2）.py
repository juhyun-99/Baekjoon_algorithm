N, M = map(int,input().split())

s = []
def dfs(num):
    if len(s) == M:
        print(*s)
        return
    else:
        for i in range(num + 1, N + 1):
            s.append(i)
            dfs(i)
            s.pop()
dfs(0)

