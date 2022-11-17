import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
ans = []
visit = [0] * n
s = []

def dfs(num):
    if len(ans) == m:
        if ' '.join(map(str, ans)) not in s:
            s.append(' '.join(map(str, ans)))
        return

    for i in range(num, n):
        if visit[i] == 0:
            ans.append(arr[i])
            visit[i] = 1
            dfs(i + 1)
            ans.pop()
            visit[i] = 0

dfs(0)

for i in s:
    print(i)