import sys
from collections import deque
input= sys.stdin.readline
sys.setrecursionlimit(2600)

N,M = map(int,input().split())

graph = [[] for _ in range(N+1)]

visit = [False]*(N+1)


for _ in range(M):
    v1,v2 = map(int,input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

def bfs(start):
    queue = deque([start])
    visit[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visit[i]:
                queue.append(i)
                visit[i]=True

cnt = 0
for i in range(1,N+1):
    if not visit[i]: 
        bfs(i)
        cnt+=1
print(cnt)