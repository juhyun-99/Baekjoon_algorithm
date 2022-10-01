N = int(input())
graph = [[]*i for i in range(N+1)]

M = int(input())
for _ in range(M):
    v1,v2 = map(int,input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

    visit = [0]*(N+1)

def dfs(graph,v):
    visit[v] = 1

    for i in graph[v]:
        if visit[i] ==0:
            dfs(graph,i)

dfs(graph,1)
print(sum(visit)-1)
  
