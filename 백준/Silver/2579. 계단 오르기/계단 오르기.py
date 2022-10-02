#2579 계단 오르기
import sys; input = sys.stdin.readline
N = int(input())
dp = [0] * (N + 1)
stairs = [0] + [int(input()) for _ in range(N)]

# 계단이 2개 이하인 경우
if len(stairs) <= 2:
    print(sum(stairs))
    exit()

#그 외
dp[1] = stairs[1] #첫 번째
dp[2] = stairs[1] + stairs[2] #두 번째
# 세 번째 이후
# 점화식1 - dp[i - 2] + stairs[i]
# 점화식2 - dp[i - 3] + stairs[i - 1] + stairs[i]
for i in range(3, N + 1):
    dp[i] = max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i])
print(dp[N])
