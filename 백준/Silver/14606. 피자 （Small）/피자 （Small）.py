import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * (n + 3)
dp[1] = 0; dp[2] = 1


for i in range(3, n + 1):
    dp[i] = (i//2 * (i-i//2)) + dp[i//2] + dp[i - i//2]
print(dp[n])