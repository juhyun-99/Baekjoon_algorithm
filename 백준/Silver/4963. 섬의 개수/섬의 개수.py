from collections import deque

def bfs(a,b):
    dx,dy=[-1,1,0,0,-1,1,-1,1],[0,0,-1,1,1,1,-1,-1]  #탐색 방향

    queue=deque([(a,b)])   
    graph[a][b]=0  #탐색을 시작하는 위치 방문 처리

    while queue:
        x,y=queue.popleft()

        for i in range(8):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<h and 0<=ny<w and graph[nx][ny]==1:
                graph[nx][ny]=0
                queue.append((nx,ny))

while True:
    w,h=map(int,input().split())
    if (w,h)==(0,0):      #종료 조건
        break

    graph=[list(map(int,input().split())) for _ in range(h)]
    count=0
    for i in range(h):
        for j in range(w):
            if graph[i][j]==1:
                bfs(i, j)
                count+=1
    print(count)