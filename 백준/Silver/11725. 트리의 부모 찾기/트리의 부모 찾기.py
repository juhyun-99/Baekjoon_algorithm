import sys; input = sys.stdin.readline
from collections import deque
N = int(input())
graph = [[] for _ in range(N+1)]
parent = [0]*(N+1)


for _ in range(N-1):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs():
    queue = deque([1])
    while queue:
        num = queue.popleft()
        for i in graph[num]:
            if parent[i] == 0 and i != 1:
                parent[i] = num
                queue.append(i)

bfs()
for i in range(2, N+1):
    print(parent[i])