import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int,input().split())

visit = [0] * 100001

q = deque()
q.append(n)
while q:
    x = q.popleft()
    if x == k:
        print(visit[x])
        break
    for tmp in (x - 1, x + 1, 2 * x):
        if 0 <= tmp <= 100000 and visit[tmp]==0:
            visit[tmp] = visit[x] + 1
            q.append(tmp)
#print(visit)