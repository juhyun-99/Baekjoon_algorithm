import sys
input = sys.stdin.readline

N, M, R = map(int, input().split())
arr = [list(map(int,input().split())) for _ in range(N)]

def c():
    for i in range(min(N,M)//2):
        x, y = i, i
        p = arr[x][y]

        for j in range(i + 1, N - i): #좌
            x = j
            tmp = arr[x][y]
            arr[x][y] = p
            p = tmp
        for j in range(i + 1, M - i): #하
            y = j
            tmp = arr[x][y]
            arr[x][y] = p
            p = tmp
        for j in range(i + 1, N - i): # 우
            x = N - j - 1
            tmp = arr[x][y]
            arr[x][y] = p
            p = tmp
        for j in range(i + 1, M - i): # 상
            y = M - j - 1
            tmp = arr[x][y]
            arr[x][y] = p
            p = tmp

for _ in range(R):
    c()

for i in range(N):
    for j in range(M):
        print(arr[i][j],end= ' ')
    print()