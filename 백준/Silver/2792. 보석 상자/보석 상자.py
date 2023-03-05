import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [int(input()) for _ in range(m)]

start = 1
end = max(arr)
cnt = 1e19

while start <= end:
    mid = (start + end) //2
    ans = 0
    for color in arr:
        ans += color // mid
        if color % mid > 0:
            ans += 1

    if ans <= n:
        cnt = min(cnt, mid)
        end = mid - 1
    else:
        start = mid + 1

print(cnt)