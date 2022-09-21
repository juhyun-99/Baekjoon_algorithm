#특정 거리의 도시 찾기
import sys; input = sys.stdin.readline
from collections import deque

N, M, K, X = map(int,input().split())

graph = [[]*i for i in range(N + 1)]
visit = [-1] * (N + 1)
visit[X] = 0

for _ in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)

def bfs(x):
    queue = deque()
    queue.append(x)
    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if visit[i] == -1 or visit[i] > visit[x] + 1:
                visit[i] = visit[x] + 1
                queue.append(i)

bfs(X)
cnt = 0
for i in range(N+1):
    if visit[i] == K:
        cnt+=1
        print(i)
if cnt==0:
    print(-1)
