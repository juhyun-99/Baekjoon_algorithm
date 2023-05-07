import sys
from collections import deque

input =sys.stdin.readline
n,k = map(int,input().split())
visit = [0] * 100001

dic = {}
def dfs(n):
    q = deque()
    q.append((n, 0))
    visit[n] = True
    while q:
        x, y = q.popleft();
        if x == k:
            print(y)
            tmp = [x]
            for i in range(y):
                tmp.append(dic[x])
                x = dic[x]
            print(*tmp[::-1])
            break
        for i in (x * 2, x - 1 , x + 1):
            if 0 <= i <= 100000 and not visit[i]:
                visit[i] = True
                dic[i] = x
                q.append((i, y + 1))
dfs(n)