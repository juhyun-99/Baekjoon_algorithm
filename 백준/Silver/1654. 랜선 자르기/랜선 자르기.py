import sys
input = sys.stdin.readline
k,n = map(int,input().split())
arr = [int(input()) for _ in range(k)]

start = 1
end = max(arr)
ans = 0
while start <= end:
    mid = (start + end) //2
    cnt = 0
    for i in arr:
        cnt += i//mid

    if cnt >= n:
        ans = mid
        start = mid + 1

    else:
        end = mid - 1

print(ans)