import sys
input = sys.stdin.readline

N = int(input())

arr = [0 for _ in range(1001)]

for _ in range(N):
    N, L = map(int, input().split())
    arr[N] = L

idx = arr.index(max(arr))

num = 0
ans = 0
for i in range(idx + 1):
    num = max(num, arr[i])
    ans += num

num = 0
for i in range(1000, idx, -1):
    num = max(num, arr[i])
    ans += num

print(ans)