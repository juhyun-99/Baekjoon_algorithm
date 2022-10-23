N = int(input())

if N ==1:
    print(4)
    exit()
elif N == 2:
    print(6)
    exit()
elif N == 3:
    print(10)
    exit()
dp = [0] * (N + 3)
dp[1], dp[2] = 1, 1
for i in range(3, N + 1):
    dp[i] = dp[i-2] + dp[i-1]
print(dp[N]*3 + dp[N-1]*2 + dp[N-2]*2 + dp[N-3])
