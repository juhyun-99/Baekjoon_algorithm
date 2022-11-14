import sys
input = sys.stdin.readline
N, M = map(int,input().split())
arr = sorted(list(map(int, input().split())))
s = []

def dfs(num):
    if len(s) == M:
        print(*s)
        return
    else:
        for i in range(num, N):
            s.append(arr[i])
            dfs(i)
            s.pop()
dfs(0)