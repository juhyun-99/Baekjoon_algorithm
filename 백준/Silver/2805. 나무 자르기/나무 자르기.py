import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

start = 0
end = max(arr)

while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for tree in arr:
        if tree > mid:
            cnt += tree - mid

    if cnt >= m:
        start = mid + 1

    else:
        end = mid - 1

print(end)