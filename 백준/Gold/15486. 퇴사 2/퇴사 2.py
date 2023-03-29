import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * (n+1)
t = [] #기간
p = [] #금액

for _ in range(n):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)

tmp = 0
for i in range(n):
    tmp = max(tmp, dp[i])
    if i + t[i] <= n:
        dp[i + t[i]] = max(dp[i + t[i]], tmp + p[i])

print(max(dp))