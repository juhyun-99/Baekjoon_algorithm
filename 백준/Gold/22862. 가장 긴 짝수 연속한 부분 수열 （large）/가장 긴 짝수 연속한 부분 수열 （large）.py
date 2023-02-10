import sys

input = sys.stdin.readline
n, k = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0
s,e = 0,0
ans = 0
while e < n:
    if arr[e] % 2 == 1:
        cnt += 1
        e += 1
    elif arr[e] % 2 == 0:
        e += 1

    if 0 <= cnt <= k:
        ans = max(ans,e - cnt - s)

    else:
        if arr[s] % 2 == 1:
            cnt -= 1
        s += 1

print(ans)
