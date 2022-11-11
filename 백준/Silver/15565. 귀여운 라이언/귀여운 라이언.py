import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))
arr2 = []
for i in range(N):
    if arr[i] == 1:
        arr2.append(i)


if len(arr2) < K:
    print(-1)
    exit()

ans = float('Inf')
end = K - 1
while end < len(arr2):
    ans = min(ans, arr2[end] - arr2[end + 1 - K])
    end += 1
print(ans + 1)