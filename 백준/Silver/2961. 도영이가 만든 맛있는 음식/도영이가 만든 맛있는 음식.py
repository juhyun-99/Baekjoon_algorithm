import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]

visit = [False] * n
tmp = []
ans = 1e19

def dfs(cnt, start):
    global ans

    if cnt >= 1:
        aa = 1;
        bb = 0;
        for i in tmp:
            a, b = arr[i]
            aa *= a
            bb += b
        ans = min(ans, abs(aa - bb))

    for i in range(start, n):
        if visit[i]:
            continue
        visit[i] = True
        tmp.append(i)
        dfs(cnt + 1, i + 1)
        visit[i] = False
        tmp.pop()

dfs(0, 0)
print(ans)