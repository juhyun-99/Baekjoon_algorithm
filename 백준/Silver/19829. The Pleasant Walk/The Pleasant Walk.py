import sys
input = sys.stdin.readline

N, K = map(int,input().split())
arr = list(map(int, input().split()))


ans = 1
end = 1
cnt = [arr[0]]

while end < N:
    if cnt[-1] != arr[end]:
        cnt.append(arr[end])
        end += 1
    else:
        cnt = [arr[end]]
        end += 1
    ans = max(ans, len(cnt))

print(ans)
