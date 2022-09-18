import sys; input = sys.stdin.readline
from collections import deque
N = int(input())
graph = [list(map(int,input().rstrip())) for _ in range(N)]

def dfs(x, y):
    global num

    if x<0 or x >= N or y < 0 or y >= N:
        return False

    if graph[x][y] == 1:
        graph[x][y] = 0
        num+=1
        dfs(x + 1, y)
        dfs(x - 1, y)
        dfs(x, y + 1)
        dfs(x, y - 1)

        return True
    return False

result = 0
ans = []
num = 0
for i in range(N):
    for j in range(N):
        if dfs(i,j) == True:
            result += 1
            ans.append(num)
            num = 0
print(result)
ans.sort()
print(*ans,sep = '\n')

