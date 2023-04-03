import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
dp = [[0] * n for _ in range(n)]

for i in range(n):
    for a in range(n - i):
        b = a + i
        if a == b:
            dp[a][b] = 1

        elif arr[a] == arr[b]:
            if dp[a + 1][b - 1] == 1:
                dp[a][b] = 1
            elif arr[a:b + 1] == list(reversed(arr[a:b + 1])):
                dp[a][b] = 1

m = int(input())
ans = []
for _ in range(m):
    s, e = map(int, input().split())
    ans.append(dp[s - 1][e - 1])

print(*ans, sep='\n')