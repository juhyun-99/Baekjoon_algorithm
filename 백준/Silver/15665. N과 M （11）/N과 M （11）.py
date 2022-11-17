import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = set(list(map(int, input().split())))
lst = sorted(list(set(arr)))
lst.sort()
ans = []
s = []

def dfs(cnt):
    if cnt == m:
        a = ' '.join(map(str, ans))
        print(a)
        return
    cnt += 1
    for i in range(len(lst)):
        ans.append(lst[i])
        dfs(cnt)
        ans.pop()
dfs(0)
