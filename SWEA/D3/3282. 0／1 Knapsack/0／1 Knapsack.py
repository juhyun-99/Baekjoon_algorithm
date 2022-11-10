T = int(input())

for tc in range(1 , T + 1):
    N, K = map(int, input().split())
    arr = [list(map(int,input().split())) for _ in range(N)]
    dp = [[0] * (K + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        for j in range(1, K + 1):
            if j < arr[i-1][0]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - arr[i - 1][0]] + arr[i - 1][1])

    #print(*dp, sep = '\n')
    tmp = 0
    for i in dp:
        tmp = max(tmp, max(i))
    print(f'#{tc} {tmp}')


