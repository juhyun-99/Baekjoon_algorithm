import sys
input = sys.stdin.readline
n = int(input())
arr = [0] + [int(input()) for _ in range(n)]
if n <= 2:
    print(sum(arr))
    exit()

dp = [0] * (n + 1)
dp[1] = arr[1]; dp[2] = arr[2] + arr[1]
for i in range(3, n + 1):
    dp[i] = max(arr[i] + arr[i - 1] + dp[i - 3], arr[i] + dp[i - 2], dp[i-1])
    #print(dp)

print(dp[n])