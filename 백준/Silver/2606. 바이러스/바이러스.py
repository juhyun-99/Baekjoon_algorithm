import sys
input = sys.stdin.readline
n = int(input())
graph = [[]*i for i in range(n+1)]

m = int(input())
for _ in range(m):
    v1,v2 = map(int,input().rstrip().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

    visit = [0]*(n + 1)

def dfs(graph, v):
    visit[v] = 1

    for i in graph[v]:
        if visit[i] == 0:
            dfs(graph, i)

dfs(graph, 1)
print(sum(visit) - 1)