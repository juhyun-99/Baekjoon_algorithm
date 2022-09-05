import sys
from collections import deque
input= sys.stdin.readline
sys.setrecursionlimit(2600)

N,M = map(int,input().split())
#그래프
graph = [[] for _ in range(N+1)]
#방문
visit = [False]*(N+1)

#그래프 넣기
for _ in range(M):
    v1,v2 = map(int,input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

#bfs구현
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
    if not visit[i]: #방문이 False일때만
        bfs(i)
        cnt+=1
print(cnt)
      


  