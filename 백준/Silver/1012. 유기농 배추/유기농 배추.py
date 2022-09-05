import sys
input = sys.stdin.readline
sys.setrecursionlimit(2600)
T = int(input())
def dfs(x,y):
    if x<=-1 or x>=M or y<=-1 or y>=N:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(x+1,y)
        dfs(x-1,y)
        dfs(x,y+1)
        dfs(x,y-1)
        return True
    return False

for _ in range(T):
    cnt = 0
    M,N,K = map(int,input().split())
    graph = [[0]*N for _ in range(M)]

    for _ in range(K):
        v1,v2 = map(int,input().split())
        graph[v1][v2] = 1

    for i in range(M):
        for j in range(N):
            if dfs(i,j) == True:
                cnt+=1
    print(cnt)
  