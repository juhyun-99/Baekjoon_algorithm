import sys; input = sys.stdin.readline
N = int(input())
dp = [0] * (N + 1)
stairs = [0] + [int(input()) for _ in range(N)]


if len(stairs) <= 2:
    print(sum(stairs))
    exit()

dp[1] = stairs[1]
dp[2] = stairs[1] + stairs[2] 

for i in range(3, N + 1):
    dp[i] = max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i])
print(dp[N])