import sys
from collections import deque

input =sys.stdin.readline
n,k = map(int,input().split())
visit = [False] * 100001
def dfs(n):
    q = deque()
    q.append((n, 0))
    visit[n] = True
    while q:
        x, y = q.popleft();
        if x == k:
            print(y)
            break
        for i in (x*2, x - 1 , x + 1):
            if 0 <= i <= 100000 and not visit[i]:
                visit[i] = True
                if i == x*2:
                    q.append((i,y))
                else:
                    q.append((i, y + 1))


dfs(n)