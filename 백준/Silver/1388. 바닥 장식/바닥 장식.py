import sys
input = sys.stdin.readline
N,M = map(int,input().split())
graph = [list(input().strip()) for _ in range(N)]
ans = 0
def dfs1(x,y):
    if x<=-1 or x>=N or y<=-1 or y>=M:
        return False
    if graph[x][y] == '-':
        graph[x][y] = 1
        dfs1(x,y+1)
        dfs1(x,y-1)
        return True
    return False

def dfs2(x,y):
    if x<=-1 or x>=N or y<=-1 or y>=M:
        return False
    if graph[x][y] =='|':
        graph[x][y] = 1
        dfs2(x+1,y)
        dfs2(x-1,y)
        return True
    return False
  
for i in range(N):
    for j in range(M):
        if graph[i][j] == '-':
            dfs1(i,j)
            ans+=1
        elif graph[i][j] =='|':
            dfs2(i,j)
            ans+=1

print(ans)
