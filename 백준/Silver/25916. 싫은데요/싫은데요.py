import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

end = 0
start = 0
cnt = 0
ans = 0
while end < N:
    if cnt <= M :
        cnt += arr[end]
        end += 1
    elif cnt > M:
        cnt-= arr[start]
        start += 1
    if cnt <= M:
        ans = max(cnt, ans)

print(ans)