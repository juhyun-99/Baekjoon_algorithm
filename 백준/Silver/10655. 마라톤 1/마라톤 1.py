import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]

d = 0
for i in range(1, n):
    d += abs(arr[i][0] - arr[i - 1][0]) + abs(arr[i][1] - arr[i-1][1])

ans = 1e9
for i in range(1, n - 1):
    tmp = d
    tmp -= (abs(arr[i][0] - arr[i - 1][0]) + abs(arr[i][1] - arr[i-1][1]))
    tmp -= (abs(arr[i + 1][0] - arr[i][0]) + abs(arr[i + 1][1] - arr[i][1]))
    tmp += (abs(arr[i + 1][0] - arr[i - 1][0]) + abs(arr[i + 1][1] - arr[i - 1][1]))
    ans = min(ans, tmp)

print(ans)

