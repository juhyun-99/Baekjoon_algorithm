T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
    N = int(input())
    arr = list(map(int,input().split()))
    dp = [0] * N
    dp[0] = 1
    for i in range(1, N):
        for j in range(i - 1, -1, -1):
            if arr[i] > arr[j]:
                dp[i] = max(dp[i], dp[j])
        dp[i] += 1


    print(f'#{tc} {max(dp)}')