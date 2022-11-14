import sys
N, M = map(int,input().split())
arr = sorted(list(map(int, input().split())))
s = []

def dfs():
    if len(s) == M:
        print(*s)
        return
    else:
        for i in range(0, N):
            s.append(arr[i])
            dfs()
            s.pop()
dfs()