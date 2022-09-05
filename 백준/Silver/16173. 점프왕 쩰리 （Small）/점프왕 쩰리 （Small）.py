from collections import deque
import sys
N = int(input())

graph = [list(map(int,input().split())) for _ in range(N)]
visit=[[0]*N for _ in range(N)]

def bfs(x,y):
    if x<=-1 or x>=N or y<=-1 or y>=N or visit[x][y]==1:
        return False

    if graph[x][y]==-1:
        visit[x][y]=1
        return
  
    visit[x][y] = 1
    move = graph[x][y]
    bfs(x,y+move)
    bfs(x+move,y)

bfs(0,0)

if visit[-1][-1]==1:
    print('HaruHaru')
else: print('Hing')
    

