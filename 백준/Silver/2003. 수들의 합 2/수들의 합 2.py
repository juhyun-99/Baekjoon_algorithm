import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int,input().split()))
start = 0
end = 0

ans = 0
cnt = arr[0]

while end < N:
    if cnt < M:
        end += 1
        if end >= N:
            break
        cnt += arr[end]

    elif cnt > M:
        cnt -= arr[start]
        start += 1

    else:
        ans += 1
        end += 1
        if end >= N:
            break
        cnt += arr[end]

print(ans)