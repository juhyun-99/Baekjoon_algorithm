import sys
input = sys.stdin.readline
C, R = map(int, input().split())

graph = [[0] * C for _ in range(R)]
K = int(input())
if K > C*R:
    print(0)
    sys.exit()

else:
    x, y = R - 1, 0
    graph[x][y] = 1
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    i = 0
    for j in range(2, K + 1):
        x += dx[i]
        y += dy[i]
        if 0 <= x < R and 0 <= y < C and graph[x][y] == 0:
            graph[x][y] = j
        else:
            x -= dx[i]
            y -= dy[i]
            i += 1
            if i == 4:
                i = 0
            x += dx[i]
            y += dy[i]
            graph[x][y] = j
    print(y + 1, R - x)
