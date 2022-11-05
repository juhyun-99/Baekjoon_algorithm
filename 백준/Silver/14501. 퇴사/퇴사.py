import sys
input = sys.stdin.readline
n = int(input())
arr = [[0,0]]
for _ in range(n):
    arr.append(list(map(int, input().split())))

dp = [0] * (n + 2)

ans = 0
for i in range(1, n + 2):
    dp[i] = max(dp[i], dp[i - 1])
    if i < n + 1:
        t, p = arr[i][0], arr[i][1]
        if i + t > n + 1:
            continue
        dp[i + t]  = max(dp[i + t], dp[i] + p)

print(max(dp))

