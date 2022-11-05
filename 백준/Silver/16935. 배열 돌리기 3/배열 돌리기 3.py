import sys
input = sys.stdin.readline
N, M, R = map(int, input().split())
arr = list(list(map(int, input().split())) for _ in range(N))

nums = list(map(int, input().split()))

for num in nums:
    N, M= len(arr), len(arr[0])
    if num == 1:
        l = [[0] * M for _ in range(N)]
        for i in range(N):
            for j in range(M):
                l[i][j] = arr[N- i - 1][j]

    elif num == 2:
        l = [[0] * M for _ in range(N)]
        for i in range(N):
            for j in range(M):
                l[i][j] = arr[i][M - j - 1]

    elif num == 3:
        l = [[0] * N for _ in range(M)]
        for i in range(M):
            for j in range(N):
                l[i][j] = arr[N-j-1][i]

    elif num == 4:
        l = [[0] * N for _ in range(M)]
        for i in range(M):
            for j in range(N):
                l[i][j] = arr[j][M-i-1]

    elif num == 5:
        l = [[0] * M for _ in range(N)]
        #4 -> 1
        for i in range(0, N//2):
            for j in range(0, M//2):
                l[i][j] = arr[i + N//2][j]
        #1 -> 2
        for i in range(0, N//2):
            for j in range(M//2 , M):
                l[i][j] = arr[i][j - M//2]

        # 3 -> 4
        for i in range(N//2, N):
            for j in range(0, M//2):
                l[i][j] = arr[i][j - M//2]
        #2 -> 3
        for i in range(N//2,N):
            for j in range(M//2, M):
                l[i][j] = arr[i - N//2][j]
    else:
        l = [[0] * M for _ in range(N)]
        # 2 -> 1
        for i in range(0, N // 2):
            for j in range(0, M // 2):
                l[i][j] = arr[i][j + M//2]
        # 3 -> 2
        for i in range(0, N // 2):
            for j in range(M // 2, M):
                l[i][j] = arr[i + N//2][j]

        # 1 -> 4
        for i in range(N // 2, N):
            for j in range(0, M // 2):
                l[i][j] = arr[i - N//2][j]
        # 4 -> 3
        for i in range(N // 2, N):
            for j in range(M // 2, M):
                l[i][j] = arr[i][j - M//2]

    arr = l


for i in arr:
    print(*i,sep = ' ')