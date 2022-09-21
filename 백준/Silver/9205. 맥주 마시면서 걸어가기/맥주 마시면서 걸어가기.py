import sys; input = sys.stdin.readline
from collections import deque
t = int(input())

def bfs(x,y):
    queue = deque()
    queue.append([x, y])
    while queue:
        x,y = queue.popleft()
        if abs(x - endx)+abs(y - endy) <= 1000:
            print('happy')
            return
        for i in range(n):
            if visit[i] == 0:
                nx, ny = conv[i]
                if abs(x - nx) + abs(y - ny) <= 1000:
                    queue.append([nx, ny])
                    visit[i] = 1
    print('sad')
    return False

for _ in range(t):
    n = int(input())
    start = [list(map(int,input().split()))]
    conv = [list(map(int,input().split())) for _ in range(n)]
    endx,endy = map(int,input().split())
    visit = [0 for i in range(n+1)]
    bfs(start[0][0], start[0][1])


