from collections import deque

N,M,V = map(int,input().split())
graph = [[]*i for i in range(N+1)]

for _ in range(M):
    v1,v2 = map(int,input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

for i in graph:
    i.sort()

visit_b = [0]*(N+1)
visit_d = [0]*(N+1)


def dfs(graph,v):
    visit_d[v] = 1
    print(v,end=' ')
    for i in graph[v]:
        if visit_d[i] == 0:
            dfs(graph,i)

def bfs(graph,start,visit):
    queue = deque([start])
    visit[start] = 1
    while queue:
        v = queue.popleft()
        print(v,end=' ')
        for i in graph[v]:
            if visit[i] == 0:
                queue.append(i)
                visit[i] = 1

dfs(graph,V)
print()
bfs(graph,V,visit_b)