import sys; input = sys.stdin.readline

n = int(input())
graph = [[]*i for i in range(n+1)]
a,b = map(int,input().split())
m = int(input())

for _ in range(m):
    n1,n2 = map(int,input().split())
    graph[n1].append(n2)
    graph[n2].append(n1)


visit = [0]*(n+1)
chon = [0]*(n+1)

def dfs(v):
    visit[v] = 1
    for i in graph[v]:
        if visit[i] == 0:
            chon[i] = chon[v]+1
            dfs(i)

dfs(a)
if chon[b]==0:
    print(-1)
else: print(chon[b])